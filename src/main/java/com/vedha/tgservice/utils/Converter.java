package com.vedha.tgservice.utils;

import java.util.ArrayList;
import java.util.List;

import com.vedha.tgservice.dto.CustShipperDTO;
import com.vedha.tgservice.dto.CustTransporterDTO;
import com.vedha.tgservice.dto.ProductMstDTO;
import com.vedha.tgservice.dto.VehicleMstDTO;
import com.vedha.tgservice.entity.CustShipperEntity;
import com.vedha.tgservice.entity.CustTransporterEntity;
import com.vedha.tgservice.entity.ProductMstEntity;
import com.vedha.tgservice.entity.VehicleMstEntity;

public class Converter {

	public static CustShipperDTO shipperEntityToDTO(CustShipperEntity shipperEntity) {
		
		CustShipperDTO shipperdto=new CustShipperDTO();
		shipperdto.setShipID(shipperEntity.getShipID());
		shipperdto.setCustID(shipperEntity.getCustID());
		shipperdto.setWebsite(shipperEntity.getWebsite());
		shipperdto.setEstdOnDate(shipperEntity.getEstdOnDate());
		shipperdto.setAddressLine1(shipperEntity.getAddressLine1());
		shipperdto.setAddressLine2(shipperEntity.getAddressLine2());
		shipperdto.setArea(shipperEntity.getArea());
		shipperdto.setStateID(shipperEntity.getStateID());
		shipperdto.setCity(shipperEntity.getCity());
		shipperdto.setDistrict(shipperEntity.getDistrict());
		shipperdto.setPincode(shipperEntity.getPincode());
		shipperdto.setServiceTaxType(shipperEntity.getServiceTaxType());
		shipperdto.setServiceTaxValue(shipperEntity.getServiceTaxValue());
		shipperdto.setPanNum(shipperEntity.getPanNum());
		shipperdto.setTinNum(shipperEntity.getTinNum());
		shipperdto.setCompanyName(shipperEntity.getCompanyName());
		shipperdto.setProductList(productEntityToproductDTO(shipperEntity.getProductList()));
	
		
		return shipperdto;
	}

	
public static List<ProductMstDTO> productEntityToproductDTO( List<ProductMstEntity> productEntityValue) {
		
	   ProductMstDTO productdto=new ProductMstDTO();
	   List<ProductMstDTO> productList = new ArrayList<ProductMstDTO>();
		
        for (ProductMstEntity EntityValue : productEntityValue) {
        	productdto.setProductID(EntityValue.getProductID());
        	productdto.setProductName(EntityValue.getProductName());
        	productdto.setProductCategory(EntityValue.getProductCategory());
        	productdto.setProductDetails(EntityValue.getProductDetails());
        	productdto.setProductAdditonalInfo(EntityValue.getProductAdditonalInfo());
      
		}
		
        productList.add(productdto);
		return productList;
		
}


public static CustTransporterDTO transportEntityDTO(CustTransporterEntity transportEntity) {
	CustTransporterDTO transportdto=new CustTransporterDTO();
	transportdto.setTransID(transportEntity.getTransID());
	transportdto.setCustID(transportEntity.getCustID());
	transportdto.setWebsite(transportEntity.getWebsite());
	transportdto.setEstdOnDate(transportEntity.getEstdOnDate());
	transportdto.setAddressLine1(transportEntity.getAddressLine1());
	transportdto.setAddressLine2(transportEntity.getAddressLine2());
	transportdto.setArea(transportEntity.getArea());
	transportdto.setStateID(transportEntity.getStateID());
	transportdto.setCity(transportEntity.getCity());
	transportdto.setDistrict(transportEntity.getDistrict());
    transportdto.setPincode(transportEntity.getPincode());
    transportdto.setServiceTaxType(transportEntity.getServiceTaxType());
    transportdto.setServiceTaxValue(transportEntity.getServiceTaxValue());
    transportdto.setPanNum(transportEntity.getPanNum());
    transportdto.setTinNum(transportEntity.getTinNum());
    transportdto.setVehicleList(vehicleEntityToproductDTO(transportEntity.getVehicleList()));
	
	
	return transportdto;
}

public static List<VehicleMstDTO> vehicleEntityToproductDTO( List<VehicleMstEntity> vehicleEntityValue) {
	
	   VehicleMstDTO vehicledto=new VehicleMstDTO();
	   List<VehicleMstDTO> vehicleList = new ArrayList<VehicleMstDTO>();
		
     for (VehicleMstEntity EntityValue : vehicleEntityValue) {
    	 vehicledto.setVehicleID(EntityValue.getVehicleID());
    	 vehicledto.setVehicleRegNum(EntityValue.getVehicleRegNum());
    	 vehicledto.setIsCovered(EntityValue.getIsCovered());
    	 vehicledto.setPermitStateName(EntityValue.getPermitStateName());
    	 vehicledto.setVehicleTypeName(EntityValue.getVehicleTypeName());
    	 vehicledto.setVehicleTypeDesc(EntityValue.getVehicleTypeDesc());
    	 vehicledto.setVehicleHeight(EntityValue.getVehicleHeight());
    	 vehicledto.setVehicleWidth(EntityValue.getVehicleWidth());
    	 vehicledto.setVehicleLength(EntityValue.getVehicleLength());
    	 vehicledto.setVehicleCapacity(EntityValue.getVehicleCapacity());
    	 vehicledto.setWheelLength(EntityValue.getWheelLength());
    	 vehicledto.setVehicleInsurDate(EntityValue.getVehicleInsurDate());
    	 vehicledto.setVehicleFCDate(EntityValue.getVehicleFCDate());
   
		}
		
     vehicleList.add(vehicledto);
		return vehicleList;
		
}

}
