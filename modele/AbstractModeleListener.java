package modele;

public class AbstractModeleListener{

    private ArrayList<AbstractModeleListener> listeners;

    public AbstractModeleListener(ArrayList<ModeleListener> l){
      this.listeners=l;
    }

    public void addListener(ModeleListener l){
      listeners.add(l);
      l.modeleUpdated(this);
    }

    public void removeListener(){
      listeners.remove(l);
    }

    protected void fireChange(){
      for(int o = 0; o < this.listeners.size();o++){
        this.listeners.get(o).modeleUpdated(this);
      }
    }

}
