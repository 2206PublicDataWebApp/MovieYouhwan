package kr.co.movieyouhwan.user.pay.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class IamportController {
	private IamportClient api;

	public IamportController() {
		this.api = new IamportClient("3444473087736002",
				"Irl5psPFM8nSv6VstWtW3A4BBu6XOcYTZZ5TdPpiBTYE5MBEWLaCoDdXbJlRzJ7s1CH6bLdtSyXpU0vH");
	}

	@ResponseBody
	@RequestMapping(value = "/pay/verify.yh")
	public IamportResponse<Payment> paymentByImpUid(Model model, Locale locale, HttpSession session,
			@RequestParam(value = "imp_uid") String imp_uid) throws IamportResponseException, IOException {
		return api.paymentByImpUid(imp_uid);
	}

}
