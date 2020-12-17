package org.yal.app.cours.screens.main.model;

import org.yal.app.cours.model.Personnage;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private List<Personnage> personnages;
    private String[] colonnes = {"Id", "Nom",  "Pv", "Pv Max"};

    public TableModel(List<Personnage> personnages) {
        this.personnages = personnages;
        addTableModelListener(e -> {
            // TODO: add treatment
        });
    }

    @Override
    public int getRowCount() {
        return personnages.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public String getColumnName(int col) {
        return colonnes[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return getPersonnageValue(personnages.get(rowIndex), columnIndex);
    }

    private Object getPersonnageValue(Personnage personnage, int i) {
        switch (i) {
            case 0: return personnage.getId();
            case 1: return personnage.getNom();
            case 2: return personnage.getPv();
            case 3: return personnage.getPvMax();
            default: return null;
        }
    }
}
