package cw_new.entitys;
public class Sensor extends Produkt {
  private String Nr;

  public Sensor(String name, double preis, String nr) {
      super(name, preis);
      this.Nr = nr;
  }

  public String getNr() {
      return Nr;
  }

  public void setNr(String nr) {
      this.Nr = nr;
  }

  @Override
  public String toString() {
      return super.toString() + ", mit der Seriennummer :" + Nr;
  }

  @Override
  public double berchnePreis() {
      return super.getPreis(); // Kann später angepasst werden
  }
}
