package cw_new.Services;
import java.util.ArrayList;
import java.util.List;

import cw_new.entitys.Produkt;

public class Lagerverwaltung {
    private List<Produkt> liste;

    public Lagerverwaltung() {
        liste = new ArrayList<>();
    }

    public List<Produkt> getListe() {
        return liste;
    }

    public void add(Produkt p) {
        if (p != null) {
            liste.add(p);
        } else {
            System.out.println("Produkt darf nicht null sein");
        }
    }

    public Produkt remove(int i) {
        if (isValidIndex(i)) {
            return liste.remove(i);
        } else {
            System.out.println("Ungültiger Index: " + i);
            return null;
        }
    }

    public void update(int i, Produkt p) {
        if (isValidIndex(i) && p != null) {
            liste.set(i, p);
        } else {
            System.out.println("Ungültiger Index oder null-Produkt");
        }
    }

    private boolean isValidIndex(int i) {
        return i >= 0 && i < liste.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lagerinhalt:\n");
        for (int i = 0; i < liste.size(); i++) {
            sb.append(i).append(": ").append(liste.get(i)).append("\n");
        }
        return sb.toString();
    }
}
