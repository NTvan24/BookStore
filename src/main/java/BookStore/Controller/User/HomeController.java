package BookStore.Controller.User;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class HomeController extends BaseController{
	
	
	@RequestMapping(value = {"/user", "/trang-chu"})
	public ModelAndView Index() {
		//ModelAndView mv= new ModelAndView("user/index");
		
		_mvShare.addObject("books",_homeService.GetDataBook());
		//_mvShare.addObject("categorys",_homeService.GetDataCategorys());
		//_mvShare.addObject("products",_homeService.GetDataProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
	@RequestMapping(value = {"/user/product"})
	public ModelAndView Product() {
		ModelAndView mv= new ModelAndView("user/product");
		
		return mv;
	}
}
