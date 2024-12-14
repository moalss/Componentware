package cw_new.entitys;
public abstract class Produkt {
  private String name;
  private double preis;
  private int id;
  private static int count = 0;

  public Produkt(String n, double p) {
      name = n;
      preis = p;
      id = ++count;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public double getPreis() {
      return preis;
  }

  public void setPreis(double preis) {
      this.preis = preis;
  }

  public abstract double berchnePreis();

  @Override
  public String toString() {
      return "Produkt [name=" + name + ", preis=" + preis + ", id=" + id + "]";
  }
}
