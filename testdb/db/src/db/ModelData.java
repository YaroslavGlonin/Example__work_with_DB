package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import db.javadbf.DBFException;
import db.javadbf.DBFField;
import db.javadbf.DBFReader;
import db.javadbf.DBFRow;
import db.javadbf.DBFUtils;

class ModelData extends AbstractTableModel {
    List<Data> data = new ArrayList<Data>();
    String colNames[] = { 
    		"PZN",
    		"UER",
    		"RGN",
    		"IND",
    		"TNP",
    		"NNP",
    		"ADR",
    		"RKC",
    		"NAMEP",
    		"NEWNUM",
    		"NEWKS",
    		"TELEF",
    		"REGN",
    		"OKPO",
    		"DATEDEL",
    		"KSNP",
    		"R_CLOSE",
    		"DATE_IN" };
    Class<?> colClasses[] = { String.class, String.class, String.class,String.class, String.class, String.class ,String.class, String.class, String.class ,String.class, String.class, String.class ,String.class, String.class, String.class ,String.class, String.class, String.class  };
    public static void addRows(
    		String PZN,
    		String UER,
    		String RGN,
    		String IND,
    		String TNP,
    		String NNP,
    		String ADR,
    		String RKC,
    		String NAMEP,
    		String NEWNUM,
    		String NEWKS,
    		String TELEF,
    		String REGN,
    		String OKPO,
    		String DATEDEL,
    		String KSNP,
    		String R_CLOSE,
    		String DATE_IN) {
    }
    public void addtoarr()
    {
    	data.add(new Data("PZN","UER","RGN","IND","TNP","NNP","ADR","RKC","NAMEP",
				"NEWNUM",
				"NEWKS",
				"TELEF",
				"REGN",
				"OKPO",
				"DATEDEL",
				"KSNP",
				"R_CLOSE",
				"DATE_IN"));
    }

    public void deltoarr(int index)
    {
    	data.remove(index);
    }

    public void sortarr(String str)
    {
    switch (str) {
    case "PZN":Collections.sort(data, new SortByPZN());break;
    case "UER":Collections.sort(data, new SortByUER());break;
    case "RGN":Collections.sort(data, new SortByRGN());break;
    case "IND":Collections.sort(data, new SortByIND());break;
    case "NNP":Collections.sort(data, new SortByNNP());break;
    case "ADR":Collections.sort(data, new SortByADR());break;
    case "RKC":Collections.sort(data, new SortByRKC());break;
    case "NAMEP":Collections.sort(data, new SortByNAMEP());break;
    case "NEWNUM":Collections.sort(data, new SortByNEWNUM());break;
    case "TELEF":Collections.sort(data, new SortByTELEF());break;
    case "REGN":Collections.sort(data, new SortByREGN());break;
    case "OKPO":Collections.sort(data, new SortByOKPO());break;
    case "DATEDEL":Collections.sort(data, new SortByDATEDEL());break;
    case "KSNP":Collections.sort(data, new SortByKSNP());break;
    case "R_CLOSE":Collections.sort(data, new SortbyR_CLOSE());break;
    default:
    	break;
    }
    	
    }
    String[] srgn=null;
    String[] suer=null;
    String[] stnp=null;
    String[] spzn=null;
    ModelData() {
    	DBFReader readerbnk = null;
    	
		try {
			readerbnk = new DBFReader(new FileInputStream("C:/Users/ENG/Desktop/DevTest/tk_spr3193/BNKDEL.DBF"));
			readerbnk.setCharactersetName("Cp866");
			int numberOfFields = readerbnk.getFieldCount();
			for (int i = 0; i < numberOfFields; i++) 
			{
				DBFField field = readerbnk.getField(i);
				//System.out.println(field.getName());
			}
			DBFRow row;
			ReplacerString pzn= new ReplacerString("C:/Users/ENG/Desktop/DevTest/tk_spr3193/PZN.DBF","PZN","NAME");
			ReplacerString tnp= new ReplacerString("C:/Users/ENG/Desktop/DevTest/tk_spr3193/TNP.DBF","TNP","FULLNAME");
			ReplacerString uer= new ReplacerString("C:/Users/ENG/Desktop/DevTest/tk_spr3193/UER.DBF","UER","UERNAME");
			ReplacerString rgn= new ReplacerString("C:/Users/ENG/Desktop/DevTest/tk_spr3193/REG.DBF","RGN","NAME");
			srgn= rgn.retcombobox();
			suer= uer.retcombobox();
			stnp= tnp.retcombobox();
			spzn= pzn.retcombobox();
			while ((row = readerbnk.nextRow()) != null) {
				 data.add(new Data(pzn.retstr(row.getString("PZN")),
						 		uer.retstr(row.getString("UER")),
						 		rgn.retstr(row.getString("RGN")),
								row.getString("IND"),
								tnp.retstr(row.getString("TNP")),
								row.getString("NNP"),
								row.getString("ADR"),
								row.getString("RKC"),
								row.getString("NAMEP"),
								row.getString("NEWNUM"),
								row.getString("NEWKS"),
								row.getString("TELEF"),
								row.getString("REGN"),
								row.getString("OKPO"),
								row.getString("DATEDEL"),
								row.getString("KSNP"),
								row.getString("R_CLOSE"),
								row.getString("DATE_IN")));
				// System.out.println(row.getString("NNP"));
			}

		} catch (DBFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			DBFUtils.close(readerbnk);
		}
		
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return colNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return data.get(rowIndex).getPZN();
        }
        if (columnIndex == 1) {
            return data.get(rowIndex).getUER();
        }
        if (columnIndex == 2) {
            return data.get(rowIndex).getRGN();
        }
        if (columnIndex == 3) {
            return data.get(rowIndex).getIND();
        }
        if (columnIndex == 4) {
            return data.get(rowIndex).getTNP();
        }
        if (columnIndex == 5) {
            return data.get(rowIndex).getNNP();
        }
        if (columnIndex == 6) {
            return data.get(rowIndex).getADR();
        }
        if (columnIndex == 7) {
            return data.get(rowIndex).getRKC();
        }
        if (columnIndex == 8) {
            return data.get(rowIndex).getNAMEP();
        }
        if (columnIndex == 9) {
            return data.get(rowIndex).getNEWNUM();
        }
        if (columnIndex == 10) {
            return data.get(rowIndex).getNEWKS();
        }
        if (columnIndex == 11) {
            return data.get(rowIndex).getTELEF();
        }
        if (columnIndex == 12) {
            return data.get(rowIndex).getREGN();
        }
        if (columnIndex == 13) {
            return data.get(rowIndex).getOKPO();
        }
        if (columnIndex == 14) {
            return data.get(rowIndex).getDATEDEL();
        }
        if (columnIndex == 15) {
            return data.get(rowIndex).getKSNP();
        }
        if (columnIndex == 16) {
            return data.get(rowIndex).getR_CLOSE();
        }
        if (columnIndex == 17) {
            return data.get(rowIndex).getDATE_IN();
        }
        return null;
    }

    public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        return colClasses[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            data.get(rowIndex).setPZN((String) aValue);
        }
        if (columnIndex == 1) {
            data.get(rowIndex).setUER((String) aValue);
        }
        if (columnIndex == 2) {
            data.get(rowIndex).setRGN((String) aValue);
        }
        if (columnIndex == 3) {
            data.get(rowIndex).setIND((String) aValue);
        }
        if (columnIndex == 4) {
            data.get(rowIndex).setTNP((String) aValue);
        }
        if (columnIndex == 5) {
            data.get(rowIndex).setNNP((String) aValue);
        }
        if (columnIndex == 6) {
            data.get(rowIndex).setADR((String) aValue);
        }
        if (columnIndex == 7) {
            data.get(rowIndex).setRKC((String) aValue);
        }
        if (columnIndex == 8) {
            data.get(rowIndex).setNAMEP((String) aValue);
        }
        if (columnIndex == 9) {
            data.get(rowIndex).setNEWNUM((String) aValue);
        }
        if (columnIndex == 10) {
            data.get(rowIndex).setNEWKS((String) aValue);
        }
        if (columnIndex == 11) {
            data.get(rowIndex).setTELEF((String) aValue);
        }
        if (columnIndex == 12) {
            data.get(rowIndex).setREGN((String) aValue);
        }
        if (columnIndex == 13) {
            data.get(rowIndex).setOKPO((String) aValue);
        }
        if (columnIndex == 14) {
            data.get(rowIndex).setDATEDEL((String) aValue);
        }
        if (columnIndex == 15) {
            data.get(rowIndex).setKSNP((String) aValue);
        }
        if (columnIndex == 16) {
            data.get(rowIndex).setR_CLOSE((String) aValue);
        }
        if (columnIndex == 17) {
            data.get(rowIndex).setDATE_IN((String) aValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    //Sort
    public class SortByDATEDEL implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getDATEDEL().compareTo(o2.getDATEDEL());
       }
    }
    public class SortByPZN implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getPZN().compareTo(o2.getPZN());
       }
    }
    public class SortByUER implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getUER().compareTo(o2.getUER());
       }
    }
    public class SortByRGN implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getRGN().compareTo(o2.getRGN());
       }
    }
    public class SortByIND implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getIND().compareTo(o2.getIND());
       }
    }
    public class SortByNNP implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getNNP().compareTo(o2.getNNP());
       }
    }
    public class SortByADR implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getADR().compareTo(o2.getADR());
       }
    }
    public class SortByRKC implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getRKC().compareTo(o2.getRKC());
       }
    }
    public class SortByNAMEP implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getNAMEP().compareTo(o2.getNAMEP());
       }
    }
    public class SortByNEWNUM implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getNEWNUM().compareTo(o2.getNEWNUM());
       }
    }
    public class SortByNEWKS implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getNEWKS().compareTo(o2.getNEWKS());
       }
    }
    public class SortByTELEF implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getTELEF().compareTo(o2.getTELEF());
       }
    }
    public class SortByREGN implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getREGN().compareTo(o2.getREGN());
       }
    }
    public class SortByOKPO implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getOKPO().compareTo(o2.getOKPO());
       }
    }
    public class SortByKSNP implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getKSNP().compareTo(o2.getKSNP());
       }
    }
    public class SortbyR_CLOSE implements Comparator<Data>
    {
       public int compare(Data o1, Data o2) {
          return o1.getR_CLOSE().compareTo(o2.getR_CLOSE());
       }
    }
}
