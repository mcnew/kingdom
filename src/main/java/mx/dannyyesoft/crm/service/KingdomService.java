package mx.dannyyesoft.crm.service;

import java.util.Collection;

import mx.dannyyesoft.crm.controller.request.KingdomCreationRequest;
import mx.dannyyesoft.crm.controller.request.KingdomUpdateRequest;
import mx.dannyyesoft.crm.controller.response.KingdomListResponse;
import mx.dannyyesoft.crm.controller.response.KingdomReadResponse;

public interface KingdomService {

	Integer create(KingdomCreationRequest request);

	KingdomReadResponse findById(Integer id);

	Integer update(Integer kingdomId, KingdomUpdateRequest request);

	Collection<KingdomListResponse> findAll();

}
