package com.royal.filetracking.uploadexcels.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GDRSPendingSupplierHelper {

//	public static List<GDRSPendingSupplier> excelToGDRSPendingSupplier(InputStream inputStream) throws IOException {
//		List<GDRSPendingSupplier> listOfGDRSPendingSuppliers = new ArrayList<>();
//		Workbook workbook = new XSSFWorkbook(inputStream);
//		try {
//			Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
//			Iterator<Row> rows=sheet.iterator();
//			int rowNumber = 0;
//			while(rows.hasNext()) {
//				Row currentRow = rows.next();
//				//skip the header
//				if(rowNumber == 0) {
//					rowNumber++;
//					continue;
//				}
//				GDRSPendingSupplier gdrsPendingSupplier = getGDRSPendingSupplierFromRow(currentRow);
//				listOfGDRSPendingSuppliers.add(gdrsPendingSupplier);
//				rowNumber++;
//			}
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			workbook.close();
//		}
//		return listOfGDRSPendingSuppliers;
//		
//	}

//	private static GDRSPendingSupplier getGDRSPendingSupplierFromRow(Row currentRow) throws ParseException {
//		GDRSPendingSupplier gdrsPendingSupplier = new GDRSPendingSupplier();
//		int cellIndex = 0;
//		
//		Iterator<Cell> cellsInRow = currentRow.iterator();
//		while(cellsInRow.hasNext()) {
//			Cell currentCell = cellsInRow.next();
//			switch(cellIndex) {
//			case 0: {
//				gdrsPendingSupplier.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
//				break;
//			}
//			case 1:{
//				gdrsPendingSupplier.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
//				break;
//			}
//			case 2:{
//				gdrsPendingSupplier.setApplDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
//				break;
//			}
//			case 3:{
//				gdrsPendingSupplier.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
//				break;
//			}
//			case 4:{
//				gdrsPendingSupplier.setSupplier(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
//				break;
//			}
//			case 5:{
//				gdrsPendingSupplier.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
//				break;
//			}
//			case 6:{
//				gdrsPendingSupplier.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
//				break;
//			}
//			case 7:{
//				gdrsPendingSupplier.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
//				break;
//			}
//			case 8:{
//				gdrsPendingSupplier.setBack(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
//				break;
//			}
//			case 9:{
//				gdrsPendingSupplier.setLastScan(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
//				break;
//			}
//			
//			
//			default:
//				break;
//			}
//			cellIndex++;
//		}
//		return gdrsPendingSupplier;
//	}

}
