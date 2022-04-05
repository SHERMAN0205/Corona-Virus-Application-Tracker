package com.sherman.Covid19Tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sherman.Covid19Tracker.models.Provinces;
import com.sherman.Covid19Tracker.services.CovidData;



@Controller
public class IndexController {
 @Autowired	
CovidData coviddata;	
private int u;
private  int lpA;
private  int ncA;
private  int mpA;
private  int kznA;
private  int wcA;
private  int ecA;
private  int fsA;
private  int gpA;
private  int nwA;
private  int totalA;

@GetMapping("/index")
public String home(Model model) {
//	Provinces provinceC =.getProvinceC();
	System.out.println("sherman");
	stats("lpC","ncC","nwC","mpC","kznC","wcC","fsC","ecC","gpC","totalC","dateC",coviddata.getProvinceC(), model);
	stats("lpD","ncD","nwD","mpD","kznD","wcD","fsD","ecD","gpD","totalD","dateD",coviddata.getProvinceD(), model);
	stats("lpR","ncR","nwR","mpR","kznR","wcR","fsR","ecR","gpR","totalR","dateR",coviddata.getProvinceR(), model);
	 int lpA= coviddata.active(coviddata.getProvinceC().getLP(), coviddata.getProvinceD().getLP(), coviddata.getProvinceR().getLP());
	 int ncA= coviddata.active(coviddata.getProvinceC().getNC(), coviddata.getProvinceD().getNC(), coviddata.getProvinceR().getNC());
  int mpA= coviddata.active(coviddata.getProvinceC().getMP(), coviddata.getProvinceD().getMP(), coviddata.getProvinceR().getMP());
	  int kznA= coviddata.active(coviddata.getProvinceC().getKZN(), coviddata.getProvinceD().getKZN(), coviddata.getProvinceR().getKZN());
	  int wcA= coviddata.active(coviddata.getProvinceC().getWC(), coviddata.getProvinceD().getWC(), coviddata.getProvinceR().getWC());
	  int ecA= coviddata.active(coviddata.getProvinceC().getEC(), coviddata.getProvinceD().getEC(), coviddata.getProvinceR().getEC());
	  int fsA= coviddata.active(coviddata.getProvinceC().getFS(), coviddata.getProvinceD().getFS(), coviddata.getProvinceR().getFS());
	  int gpA= coviddata.active(coviddata.getProvinceC().getGP(), coviddata.getProvinceD().getGP(), coviddata.getProvinceR().getGP());
	  int nwA= coviddata.active(coviddata.getProvinceC().getNW(), coviddata.getProvinceD().getNW(), coviddata.getProvinceR().getNW());	
	  int totalA=
		
	   lpA+
	   ncA+
	   mpA+
	   kznA+
	   wcA+
	   ecA+
	   fsA+
	   gpA+
	   nwA;
	  this.ncA = ncA;
	  this.mpA = mpA;
	  this.kznA = kznA;
	  this.wcA =wcA ;
	  this.ecA = ecA;
	  this.fsA = fsA;
	  this.gpA =gpA ;
	  this.lpA =lpA ;
	  this.nwA =nwA ;
	  this.totalA=totalA;
	  

    return "index";

}
private void stats(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,Provinces provincegetter, Model model) {
	Provinces province=provincegetter;
	 model.addAttribute(a ,province.getLP());
     model.addAttribute(b ,province.getNC());
     model.addAttribute(c ,province.getNW());
     model.addAttribute(d ,province.getMP());
     model.addAttribute(e ,province.getKZN());
     model.addAttribute(f ,province.getWC());
     model.addAttribute(g,province.getFS());
     model.addAttribute(h ,province.getEC());
     model.addAttribute(i ,province.getGP());
     model.addAttribute(j ,province.getTotal());
     model.addAttribute(k ,province.getDate());
     model.addAttribute("lpA" ,lpA);
     model.addAttribute("nwA" ,nwA);
     model.addAttribute("gpA" ,gpA);
     model.addAttribute("ncA" ,ncA);
     model.addAttribute("mpA" ,mpA);
     model.addAttribute("kznA" ,kznA);
     model.addAttribute("wcA" ,wcA);
     model.addAttribute("ecA" ,ecA);
     model.addAttribute("fsA" ,fsA);
     model.addAttribute("totalA" ,totalA);
  
    
}

}