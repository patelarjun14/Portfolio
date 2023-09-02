package Problem2;

//Create Queue interface
public interface IQueue {
  Queue emptyQueue();
  Boolean isEmpty();
  Queue add(Integer n);
  Boolean Contains(Integer n);
  Queue remove();
  Queue removeElement(Integer n);

  Integer size();


}
