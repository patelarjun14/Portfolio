package problem2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class SwimmerIterator implements Iterator<Swimmer> {

  private List<Swimmer> filteredSwimmers;
  private static final Integer BUTTERFLY_SWIM_TIME_CUTOFF = 5;
  private static final Double QUALIFIED_TIME = 26.17;

  public SwimmerIterator(List<Swimmer> swimmers) {
    this.filteredSwimmers = this.filterSwimmers(swimmers);
  }

  private List<Swimmer> filterSwimmers(List<Swimmer> swimmers) {
    List<Swimmer> filteredSwimmers = new ArrayList<>();
    for (Swimmer swimmer: swimmers){
      if(this.qualifiedButterfySwims(swimmer) && this.qualifiedFreestyleTime(swimmer))
        filteredSwimmers.add(swimmer);

    }

    return filteredSwimmers;
  }

  @Override
  public boolean hasNext() {
    return !filteredSwimmers.isEmpty();
  }

  private Boolean qualifiedButterfySwims(Swimmer swimmer){
    return swimmer.getButterfly50mTimes().size() >= BUTTERFLY_SWIM_TIME_CUTOFF;
  }

  private Boolean qualifiedFreestyleTime(Swimmer swimmer) {
    for(Double swimTime: swimmer.getFreestyle50mTimes()) {
      if(swimTime <= QUALIFIED_TIME)
        return true;
    }
    return false;
  }


  @Override
  public Swimmer next() {
    Swimmer helperSwimmer = this.filteredSwimmers.get(0);
    this.filteredSwimmers.remove(0);
    return helperSwimmer;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("This operation is not supported!");
  }

}
