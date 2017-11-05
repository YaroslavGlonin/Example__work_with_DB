package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import db.javadbf.DBFException;
import db.javadbf.DBFField;
import db.javadbf.DBFReader;
import db.javadbf.DBFRow;
import db.javadbf.DBFUtils;

public class ReplacerString {
	
	int SIZEMAX=83;
	String[][] values = new String[2][SIZEMAX];
	ReplacerString(String dbf,String Column1,String Column2)
	{
		DBFReader readerbnk = null;
		try {
			readerbnk = new DBFReader(new FileInputStream(dbf));
			readerbnk.setCharactersetName("Cp866");
			int numberOfFields = readerbnk.getFieldCount();
			for (int i = 0; i < numberOfFields; i++) 
			{
				DBFField field = readerbnk.getField(i);
				//System.out.println(field.getName());
			}
			DBFRow row;
			int c=0;
			while ((row = readerbnk.nextRow()) != null) 
			{
				 values[0][c]=row.getString(Column1);
				 values[1][c]=row.getString(Column2);
				 c++;
			}
			retcombobox();
		} catch (DBFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			DBFUtils.close(readerbnk);
		}
	}
	
	
	public String retstr(String input)
	{
		String outstr = null;
		int pznmain=0;
		int pznfirst=0;
		try{pznmain=Integer.parseInt(input);}catch(Exception Ex){}
		for(int i=0;i<SIZEMAX;i++)
		{
			try{pznfirst=Integer.parseInt(values[0][i]);}
			catch(Exception ex)
				{
					if(values[0][i]==null)
					{
						outstr= values[1][i]; pznfirst=0;break;
					}
					else {outstr= values[1][i]; pznfirst=0;break;}
				}
			if (pznmain==pznfirst)
			{
				outstr= values[1][i];
				break;
			}
		}
		return outstr;
	}
	String[] selt=new String[SIZEMAX];
	public String[] retcombobox()
	{
		for(int i=0;i<SIZEMAX;i++)
		{
			if(values[1][i]!=null)selt[i]=values[1][i];
		}
		return this.selt;
	}
}
