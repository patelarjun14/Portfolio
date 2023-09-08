from sklearn import datasets

blobs = datasets.make_blobs(n_samples=200, centers=2, n_features=2, cluster_std=2, random_state=3)

print(blobs[1])