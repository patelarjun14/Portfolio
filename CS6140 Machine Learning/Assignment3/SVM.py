import numpy as np
from sklearn import datasets
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt


class SVM:
    def __init__(self, C=1.0, kernel='rbf', sigma=0.1, degree=2):
        self.C = C
        if kernel == 'poly':
            self.kernel = self._polynomial_kernel
            self.C = 1
            self.degree = degree
        elif kernel == 'rbf':
            self.kernel = self._rbf_kernel
            self.sigma = sigma
        else:
            self.kernel = self._linear_kernel

        self.X = None # inputs
        self.y = None # target
        self.alpha = None # lagrangian multiplier
        self.b = 0 # bias
        self.ones = None

    def _rbf_kernel(self, X_t, X):
        return np.exp(-(1 / self.sigma ** 2) * np.linalg.norm(X_t[:, np.newaxis] - X[np.newaxis, :], axis=2) ** 2)

    def _polynomial_kernel(self, X_t, X):
        return (X_t.dot(X.T)) ** self.degree

    def _linear_kernel(self, X, X_t):
        return (X.dot(X_t.T))

    def fit(self, X, y, lr=1e-3, epochs=200):

        self.X = X
        self.y = y

        # (N,)
        self.alpha = np.ones(X.shape[0])
        # self.alpha = np.random.random(X.shape[0]) # lagrangian multiplier lambdas (can't use lambda as variable name)
        self.b = 0 # bias
        # (N,)
        self.ones = np.ones(X.shape[0])

        # (N,N) =             (N,N) *        (N,N)
        y_outer = np.outer(y, y)
        y_iy_jk_ij = y_outer * self.kernel(X, X)

        gains = []
        for _ in range(epochs):
            # (500,)  =    (500,)      (N,N).(N,)=(N,)
            gradient = self.ones - y_iy_jk_ij.dot(self.alpha)

            self.alpha = self.alpha + lr * gradient

            # This is complementary slackness
            self.alpha[self.alpha > self.C] = self.C

            # We place this as 0 to stay we dont need them
            self.alpha[self.alpha < 0] = 0

            # the lagrangian formulation of the solution
            gain = np.sum(self.alpha) - 0.5 * np.sum(np.outer(self.alpha, self.alpha) * y_iy_jk_ij)

            gains.append(gain)
            # self.plot_decision_boundary()

        index = np.where(self.alpha > 0 & (self.alpha < self.C))[0]
        # (m,)= (m,)       (n,).(n,m)= (m,)
        b_i = y[index] - (self.alpha * y).dot(self.kernel(X, X[index]))
        # Alternative code
        # b_i = y[index] - np.sum((self.alpha * y).reshape(-1, 1)*self.kernel(X, X[index]), axis=0)
        self.b = np.mean(b_i)

        plt.plot(gains)
        plt.title("loss per epochs")
        plt.show()

    def _decision_function(self, X):
        return (self.alpha * self.y).dot(self.kernel(self.X, X)) + self.b

    def predict(self, X):
        return np.sign(self._decision_function(X))

    def score(self, X, y):
        y_hat = self.predict(X)
        return np.mean(y == y_hat)

    def plot_decision_boundary(self):
        plt.scatter(self.X[:, 0], self.X[:, 1], c=self.y, s=50, cmap=plt.cm.Paired, alpha=.5)
        ax = plt.gca()
        xlim = ax.get_xlim()
        ylim = ax.get_ylim()

        # create grid to evaluate model
        xx = np.linspace(xlim[0], xlim[1], 30)
        yy = np.linspace(ylim[0], ylim[1], 30)
        YY, XX = np.meshgrid(yy, xx)
        xy = np.vstack([XX.ravel(), YY.ravel()]).T
        Z = self._decision_function(xy).reshape(XX.shape)

        # plot decision boundary and margins
        ax.contour(XX, YY, Z, colors=['b', 'g', 'r'], levels=[-1, 0, 1], alpha=0.5,
                   linestyles=['--', '-', '--'], linewidths=[2.0, 2.0, 2.0])

        # highlight the support vectors
        ax.scatter(self.X[:, 0][self.alpha > 0.], self.X[:, 1][self.alpha > 0.], s=50,
                   linewidth=1, facecolors='none', edgecolors='k')

        plt.show()


class SampleData:
    def get_binary(self, n_samples, noise=0.05, random_state=3):
        n = n_samples
        blobs = datasets.make_blobs(n_samples=n, centers=2, n_features=2, cluster_std=2, random_state=random_state)
        return blobs[0], blobs[1]

    def get_moon(self, n_samples, noise=0.05):
        noisy_moons = datasets.make_moons(n_samples=n_samples, noise=noise, random_state=6)
        return noisy_moons[0], noisy_moons[1]

    def get_donut(self, n_samples, noise=0.05, factor=0.5):
        noisy_circles = datasets.make_circles(n_samples=n_samples, factor=factor, noise=noise)
        return noisy_circles[0], noisy_circles[1]

    def plot(self, X, y):
        ax = plt.gca()
        ax.scatter(X[:, 0], X[:, 1], c=y, cmap=plt.cm.Paired)
        plt.show()


if __name__ == '__main__':
    sample = SampleData()

    X, y = sample.get_binary(n_samples=100, random_state=1)
    y[y == 0] = -1
    X_train, X_test, y_train, y_test = train_test_split(X, y, random_state=0)
    sample.plot(X_train, y_train)
    svm = SVM(C=1, kernel='linear')
    svm.fit(X, y, lr=.0001)
    print("train score:", svm.score(X_train, y_train))
    svm.plot_decision_boundary()
    print("test score:", svm.score(X_test, y_test))
    print('ok')

    # X, y = sample.get_donut(n_samples=100, noise=.05)
    # y[y == 0] = -1
    # X_train, X_test, y_train, y_test = train_test_split(X, y, random_state=0)
    # sample.plot(X_train, y_train)
    # svm = SVM(C=5.0, kernel='rbf', sigma=2)
    # svm.fit(X_train, y_train, lr=1e-3, epochs=5000)
    # print("train score:", svm.score(X, y))
    # svm.plot_decision_boundary()
    # print("test score:", svm.score(X_test, y_test))
    # print('ok')

    # X, y = sample.get_moon(n_samples=400, noise=0.1)
    # y[y == 0] = -1
    #
    # svm = SVM(C=1.0, kernel='rbf', sigma=0.5)
    # svm.fit(X, y, lr=1e-2)
    # print("train score:", svm.score(X, y))
    # svm.plot_decision_boundary()
