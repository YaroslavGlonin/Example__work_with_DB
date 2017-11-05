package db.javadbf;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * Data containdes in a row of the DBF file.
 * 
 * It has methods to ease obtain data.
 *
 */
public class DBFRow {

	private Object[] data;
	private Map<String, Integer> mapcolumnNames;
	private DBFField[] fields;

	protected DBFRow(Object[] data, Map<String, Integer> mapcolumnNames, DBFField[] fields) {
		super();
		this.data = data;
		this.mapcolumnNames = mapcolumnNames;
		this.fields = fields;
	}

	private int getColumnIndex(String columnName) {
		Objects.requireNonNull(columnName);
		String key = columnName.toLowerCase();
		Integer index = mapcolumnNames.get(key);
		if (index == null) {
			throw new DBFException("Not field name found for:" + columnName);
		}
		return index.intValue();
	}
	
	public boolean isDeleted () {
		return "deleted".equals(this.fields[0].getName()) && getBoolean("deleted");
	}

	public Object getObject(String columnName) {
		return getObject(getColumnIndex(columnName));
	}

	public Object getObject(int columnIndex) {
		return data[columnIndex];
	}

	public String getString(String columnName) {
		return getString(getColumnIndex(columnName));
	}

	public String getString(int columnIndex) {
		Object fieldValue = data[columnIndex];
		if (fieldValue == null) {
			return null;
		}
		if (fieldValue instanceof String) {
			return (String) fieldValue;
		}
		return fieldValue.toString();
	}

	public BigDecimal getBigDecimal(String columnName) {
		return getBigDecimal(getColumnIndex(columnName));
	}
	public BigDecimal getBigDecimal(int columnIndex) {
		Object fieldValue = data[columnIndex];
		if (fieldValue == null) {
			return null;
		}
		if (fieldValue instanceof BigDecimal) {
			return (BigDecimal) fieldValue;
		}
		throw new DBFException("Unsupported type for BigDecimal at column:" + columnIndex + " " + fieldValue.getClass().getCanonicalName());
	}

	public boolean getBoolean(String columnName) {
		return getBoolean(getColumnIndex(columnName));
	}

	public boolean getBoolean(int columnIndex) {
		Object fieldValue = data[columnIndex];
		if (fieldValue == null) {
			return Boolean.FALSE;
		}
		if (fieldValue instanceof Boolean) {
			return (Boolean) fieldValue;
		}
		throw new DBFException("Unsupported type for Boolean at column:" + columnIndex + " " + fieldValue.getClass().getCanonicalName());
	}
	
	
	public byte[] getBytes(String columnName) {
		return getBytes(getColumnIndex(columnName));
	}
	public byte[] getBytes(int columnIndex) {
		Object fieldValue = data[columnIndex];
		if (fieldValue == null) {
			return null;
		}
		if (fieldValue instanceof byte[]) {
			return (byte[]) fieldValue;
		}
		throw new DBFException("Unsupported type for byte[] at column:" + columnIndex + " " + fieldValue.getClass().getCanonicalName());
	}
	
	public Date getDate (String columnName) {
		return getDate(getColumnIndex(columnName));
	}
	public Date getDate(int columnIndex) {
		Object fieldValue = data[columnIndex];
		if (fieldValue == null) {
			return null;
		}
		if (fieldValue instanceof Date) {
			return (Date) fieldValue;
		}
		throw new DBFException("Unsupported type for Date at column:" + columnIndex + " " + fieldValue.getClass().getCanonicalName());
	}
	
	public double getDouble(String columnName) {
		return getDouble(getColumnIndex(columnName));
	}
	
	public double getDouble(int columnIndex) {
		Object fieldValue = data[columnIndex];
		if (fieldValue == null) {
			return 0.0;
		}
		if (fieldValue instanceof Number) {
			return ((Number) fieldValue).doubleValue();
		}
		throw new DBFException("Unsupported type for Number at column:" + columnIndex + " " + fieldValue.getClass().getCanonicalName());
	}
	public float getFloat(String columnName) {
		return getFloat(getColumnIndex(columnName));
	}
	public float getFloat(int columnIndex) {
		Object fieldValue = data[columnIndex];
		if (fieldValue == null) {
			return 0.0f;
		}
		if (fieldValue instanceof Number) {
			return ((Number) fieldValue).floatValue();
		}
		throw new DBFException("Unsupported type for Number at column:" + columnIndex + " " + fieldValue.getClass().getCanonicalName());
	}
	
	public int getInt(String columnName) {
		return getInt(getColumnIndex(columnName));
	}
	
	public int getInt(int columnIndex) {
		Object fieldValue = data[columnIndex];
		if (fieldValue == null) {
			return 0;
		}
		if (fieldValue instanceof Number) {
			return ((Number) fieldValue).intValue();
		}
		throw new DBFException("Unsupported type for Number at column:" + columnIndex + " " + fieldValue.getClass().getCanonicalName());
	}
	public long getLong (String columnName) {
		return getLong(getColumnIndex(columnName));
	}
	public long getLong (int columnIndex) {
		Object fieldValue = data[columnIndex];
		if (fieldValue == null) {
			return 0;
		}
		if (fieldValue instanceof Number) {
			return ((Number) fieldValue).longValue();
		}
		throw new DBFException("Unsupported type for Number at column:" + columnIndex + " " + fieldValue.getClass().getCanonicalName());
	}

}
