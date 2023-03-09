package com.royal.filetracking.tryTwo.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.tryTwo.model.GDRSNewRegistation;

public class ExcelHelper {

	public static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	/**
	 * Whether given file is in specific format.
	 * 
	 * @param file
	 * @return
	 */
	public static boolean hasExcelFormat(MultipartFile file) {
		// TODO Make format for all the files
//		if(TYPE.equals(file.getContentType())) {
//		return true;
//	} else {
//		return false;
//	}
		return true;
	}
	

		
	
	/**
	 * Give specific value from the cell;
	 * 
	 * @param <E>
	 * @param cell
	 * @param className
	 * @return
	 * @throws ParseException
	 */
	public static <E> E getSpecificTypeValueFromCell(Cell cell, Class<E> className) {
		// below formatter return string value regardless of cell type.
		// reference. https://www.callicoder.com/java-read-excel-file-apache-poi/
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue = dataFormatter.formatCellValue(cell);
		if(className == String.class) {
			return (E) cellValue;
		} else if(className == Long.class) {
			return (E) Long.valueOf(cellValue);
		} else if(className == Double.class) {
			return (E) Double.valueOf(cellValue);
		} else if(className == Integer.class) {
			return (E) Integer.valueOf(cellValue);
		} else if(className == Date.class) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date;
			try {
				date = formatter.parse(cellValue);
			} catch (ParseException e) {
				return null;
			}
			return (E) date;
		}
		return null;
	}
	
	
	
}