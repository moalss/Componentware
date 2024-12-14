package cw_new.entitys;
public class Container extends Produkt {
  private double volume;

  public Container(String name, double preis, double volume) {
      super(name, preis);
      this.volume = volume;
  }

  public double getVolume() {
      return volume;
  }

  public void setVolume(double volume) {
      this.volume = volume;
  }

  @Override
  public String toString() {
      return super.toString() + ", Volume=" + volume;
  }

  @Override
  public double berchnePreis() {
      return super.getPreis(); // Kann später angepasst werden
  }
}
