package mx.dannyyesoft.crm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.dannyyesoft.crm.controller.request.KingdomCreationRequest;
import mx.dannyyesoft.crm.controller.request.KingdomUpdateRequest;
import mx.dannyyesoft.crm.controller.response.KingdomListResponse;
import mx.dannyyesoft.crm.controller.response.KingdomReadResponse;
import mx.dannyyesoft.crm.entity.KingdomEntity;
import mx.dannyyesoft.crm.repository.KingdomRepository;

@Service
public class KingdomServiceImpl implements KingdomService {

	private final KingdomRepository kingdomRepository;

	@Autowired
	public KingdomServiceImpl(KingdomRepository kingdomRepository) {
		this.kingdomRepository = kingdomRepository;
	}

	@Override
	@Transactional
	public Integer create(KingdomCreationRequest request) {
		KingdomEntity entity = new KingdomEntity();
		entity.setDescription(request.getDescription());
		entity.setName(request.getName());
		entity = kingdomRepository.save(entity);
		return entity.getId();
	}

	@Override
	public KingdomReadResponse findById(Integer id) {
		KingdomEntity entity = kingdomRepository.findOne(id);
		if (entity == null) {
			return null;
		} else {
			KingdomReadResponse response = new KingdomReadResponse();
			response.setId(entity.getId());
			response.setName(entity.getName());
			response.setDescription(entity.getDescription());
			return response;
		}
	}

	@Override
	public Integer update(Integer kingdomId, KingdomUpdateRequest request) {
		KingdomEntity entity = kingdomRepository.findOne(kingdomId);
		if (entity == null) {
			return null;
		} else {
			entity.setDescription(request.getDescription());
			return entity.getId();
		}
	}

	@Override
	public Collection<KingdomListResponse> findAll() {
		List<KingdomListResponse> response = new ArrayList<>();
		List<KingdomEntity> entities = kingdomRepository.findAll();
		for (KingdomEntity entity : entities) {
			KingdomListResponse temp = new KingdomListResponse();
			temp.setId(entity.getId());
			temp.setName(entity.getName());
			response.add(temp);
		}
		return response;
	}

}
