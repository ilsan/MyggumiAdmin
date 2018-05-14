package com.sp.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.sp.domain.CommonCode;
import com.sp.domain.Product;

public class ProductExcelDownload extends AbstractExcelView{

	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String firstName = null;
		String fullName = "";
		firstName = new SimpleDateFormat("yyyyMMdd").format(new Date());
		fullName = firstName + "_상품리스트_엑셀다운로드.xls";
		
		Sheet workSheet = null;
		Row row = null;
		
		List<Product> productExcelList = (List<Product>) model.get("list");
		List<CommonCode> productTypeList = (List<CommonCode>) model.get("productType");
		List<CommonCode> productCategorylist = (List<CommonCode>) model.get("productCategory");
		workSheet = workbook.createSheet("시트명");
		
		row = workSheet.createRow(0);
		
		row.createCell(0).setCellValue("No");
		row.createCell(1).setCellValue("상품명");
		row.createCell(2).setCellValue("상품타입");
		row.createCell(3).setCellValue("카테고리");
		row.createCell(4).setCellValue("가격");
		row.createCell(5).setCellValue("사용여부");
		row.createCell(6).setCellValue("등록일");
		
		System.out.println("listExcel.size() >> " + productExcelList.size());
								
		int rowIndex = 1;
		for(Product list : productExcelList) {
			row = workSheet.createRow(rowIndex);
			row.createCell(0).setCellValue(list.getProductNo());
			row.createCell(1).setCellValue(list.getProductName());
			
			
			for (CommonCode typeList : productTypeList) {

				if (typeList.getComCd().equals(list.getProductType())) {
					row.createCell(2).setCellValue(typeList.getComNm());
					break;
				}
								
			}
			
			for(CommonCode categoryList : productCategorylist) {
				
				if(categoryList.getComCd().equals(list.getProductCategory())) {
					row.createCell(3).setCellValue(categoryList.getComNm());
					break;
				}
				
			}
			
			
			row.createCell(4).setCellValue(list.getProductPrice());
			row.createCell(5).setCellValue(list.getUseYn());
			row.createCell(6).setCellValue(list.getRegDate().toString());
			
			rowIndex++;
			
		}
		
		//컬럼길이조절
		for (int i = 0; i <  productExcelList.size(); i++){ 
        	workSheet.autoSizeColumn(i); 
        	workSheet.setColumnWidth(i, (workSheet.getColumnWidth(i)) + 2000); 
        }
		
		try {

			response.setHeader("Content-Disposition", "attachement; filename=\""
	                + java.net.URLEncoder.encode(fullName, "UTF-8") + "\";charset=\"UTF-8\"");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
	
	
	
}
