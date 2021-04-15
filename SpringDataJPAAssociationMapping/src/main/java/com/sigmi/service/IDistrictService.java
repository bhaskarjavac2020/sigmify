package com.sigmi.service;

import java.util.List;

import com.sigmi.dto.DistrictDTO;
import com.sigmi.dto.StateDTO;
import com.sigmi.entity.State;

public interface IDistrictService {
	public Integer saveStateData(StateDTO statedto)throws Exception;
	public List<StateDTO> fetchAllState() throws Exception;
	public StateDTO fetchOneState(Integer id);
	public String deleteState(Integer id);
	//public String deleteDistrict(Integer id);
	public Integer updateState(State stateDTO)throws Exception;
	public Integer updateDistrict(DistrictDTO districtDTO);
	//public Integer saveStateData(DistrictDTO distdto);

}
