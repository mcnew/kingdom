package mx.dannyyesoft.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public KingdomEntity findById(Integer id) {
		return kingdomRepository.findOne(id);
	}

}
