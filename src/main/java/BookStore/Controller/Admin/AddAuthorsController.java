package BookStore.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BookStore.Entity.Authors;
import BookStore.Service.Admin.AddAuthorServiceImpl;

@Controller
public class AddAuthorsController  extends BaseAdminController{
	@Autowired
	AddAuthorServiceImpl addAuthorService = new AddAuthorServiceImpl();
	
	@RequestMapping(value = "/admin/them-tac-gia", method = RequestMethod.GET)
	public ModelAndView ThemTacGia() {
		_mvShare.addObject("author", new Authors());	
		_mvShare.setViewName("admin/add/addauthors");
		
		return _mvShare;
	}

	@RequestMapping(value = "/admin/them-tac-gia", method = RequestMethod.POST)
	public ModelAndView AddAuthor(@ModelAttribute("author") Authors author) {
		
		int count = addAuthorService.AddAuthor(author);
		if(count > 0) {
			_mvShare.addObject("status", "Thêm tác giả thành công ");
		}
		else {
			_mvShare.addObject("status", "Thêm tác giả thất bại ");
		}
		_mvShare.setViewName("admin/add/addauthors");
		
		return _mvShare;
	}
}