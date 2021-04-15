package com.sigmi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmi.dto.DistrictDTO;
import com.sigmi.dto.StateDTO;
import com.sigmi.entity.District;
import com.sigmi.entity.State;
import com.sigmi.repository.IDistrictRepo;
import com.sigmi.repository.IStateRepo;
@Service
public class DistrictServiceImple implements IDistrictService {
	@Autowired
	private IStateRepo staterRpo;
	@Autowired
	private IDistrictRepo distRepo;
	@Override
	public Integer saveStateData(StateDTO statedto) throws Exception {
		State state1=new State();
		state1.setId(statedto.getId());
		state1.setName(statedto.getName());
		state1.setDescription(statedto.getDescription());
		List<District> listdistrict=new ArrayList<District>();
		for (DistrictDTO districtdto : statedto.getDistrictdtos()) {
			District dists=new District();
		     dists.setId(districtdto.getId());
		     dists.setName(districtdto.getName());
		     dists.setDescription(districtdto.getDescription());
				listdistrict.add(dists);
			}
		state1.setDistricts(listdistrict);
		staterRpo.save(state1);
		return state1.getId();
		
	}

	@Override
	public List<StateDTO> fetchAllState() throws Exception {
		List<StateDTO> listStateDto=new ArrayList<StateDTO>();
		List<State> listState=staterRpo.findAll();
		for (State state : listState) {
			StateDTO stateDto=new StateDTO();
			stateDto.setId(state.getId());
			stateDto.setName(state.getName());
			stateDto.setDescription(state.getDescription());
			List<DistrictDTO> listDistDto=new ArrayList<DistrictDTO>();
			for (District dist : state.getDistricts()) {
				DistrictDTO distDto=new DistrictDTO();
				distDto.setId(dist.getId());
				distDto.setName(dist.getName());
				distDto.setDescription(dist.getDescription());
				listDistDto.add(distDto);
			}
			stateDto.setDistrictdtos(listDistDto);
			listStateDto.add(stateDto);
		}
		return listStateDto;
	}

	@Override
	public StateDTO fetchOneState(Integer id) {
		Optional<State> opt=staterRpo.findById(id);
		State state=null;
		if(opt.isPresent()) {
			state=opt.get();
		}
		StateDTO statedto=new StateDTO();
		statedto.setId(state.getId());
		statedto.setName(state.getName());
		statedto.setDescription(state.getDescription());
		List<DistrictDTO> distdtoList=new ArrayList<DistrictDTO>();
		for(District dist:state.getDistricts()) {
			DistrictDTO distdto=new DistrictDTO();
			distdto.setId(dist.getId());
			distdto.setName(dist.getName());
			distdto.setDescription(dist.getDescription());
			distdtoList.add(distdto);
		}
		statedto.setDistrictdtos(distdtoList);
		return statedto;
	}
//-------------------delete specific state---------------------------------------
	@Override
	public String deleteState(Integer id) {
	if(staterRpo.existsById(id)) {
		staterRpo.deleteById(id);
		return "State with given id "+id+" removed";
	}else {
		return "invalid stateid";
	}
}
	@Override
	public Integer updateState(State stateDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateDistrict(DistrictDTO districtDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
