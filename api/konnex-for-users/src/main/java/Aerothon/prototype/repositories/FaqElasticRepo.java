package Aerothon.prototype.repositories;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import Aerothon.prototype.models.Faqs;

@Primary
public interface FaqElasticRepo extends ElasticsearchRepository<Faqs, String> {

	List<Faqs> find_all_question_with_matching_from_elasticsearch(String question) throws IOException;

}
