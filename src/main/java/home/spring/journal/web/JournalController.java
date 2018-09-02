package home.spring.journal.web;

import home.spring.journal.domain.Journal;
import home.spring.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JournalController {
	@Autowired
	JournalRepository repository;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("journal", repository.findAll());
		return "index";
	}

	@RequestMapping(value = "/journal", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<Journal> getJournal() {
		return repository.findAll();
	}

	@RequestMapping(value = "/journalxml", produces = { MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Journal> getJournalXml() {
		return repository.findAll();
	}
}
