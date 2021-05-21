package Aerothon.prototype.repositories;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;

import Aerothon.prototype.models.Faqs;

public class FaqElasticRepoImpl implements FaqElasticRepo {

	@Autowired
	RestHighLevelClient client;

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public List<Faqs> find_all_question_with_matching_from_elasticsearch(String question) throws IOException {
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices("faqs");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchQuery("question", question).fuzziness(Fuzziness.AUTO));
		searchRequest.source(searchSourceBuilder);
		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		SearchHit[] searchHit = searchResponse.getHits().getHits();
		System.out.println(searchHit);
		List<Faqs> faqList = new ArrayList<>();
		for (SearchHit hit : searchHit) {
			System.out.println(hit.getSourceAsMap());
			faqList.add(objectMapper.convertValue(hit.getSourceAsMap(), Faqs.class));
		}
		return faqList;
	}

	@Override
	public <S extends Faqs> S indexWithoutRefresh(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Faqs> search(QueryBuilder query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Faqs> search(QueryBuilder query, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Faqs> search(Query searchQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Faqs> searchSimilar(Faqs entity, String[] fields, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<Faqs> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Faqs> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Faqs> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Faqs> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Faqs> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Faqs> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Faqs> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Faqs entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Faqs> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
