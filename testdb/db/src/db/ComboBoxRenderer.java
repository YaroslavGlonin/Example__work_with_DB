package db;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class ComboBoxRenderer extends JComboBox implements TableCellRenderer {
	  public ComboBoxRenderer(String[] items) {
	    super(items);
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	      boolean hasFocus, int row, int column) {
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      super.setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      setBackground(table.getBackground());
	    }
	    setSelectedItem(value);
	    return this;
	  }
	}

	class ComboBoxEditor extends DefaultCellEditor {
	  public ComboBoxEditor(String[] items) {
	    super(new JComboBox(items));
	  }
	}
