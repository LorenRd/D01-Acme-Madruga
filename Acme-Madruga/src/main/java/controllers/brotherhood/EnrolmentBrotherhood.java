
package controllers.brotherhood;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.EnrolmentService;
import services.MemberService;
import services.PositionService;
import controllers.AbstractController;
import domain.Brotherhood;
import domain.Enrolment;
import domain.Member;
import domain.Position;

@Controller
@RequestMapping("/enrolment/brotherhood")
public class EnrolmentBrotherhood extends AbstractController {

	// Servicios

	@Autowired
	private EnrolmentService	enrolmentService;

	@Autowired
	private PositionService		positionService;

	@Autowired
	private MemberService		memberService;


	// Create

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Enrolment enrolment;

		enrolment = this.enrolmentService.create();

		result = this.createEditModelAndView(enrolment);

		return result;
	}

	// Edit

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int enrolmentId) {
		ModelAndView result;

		try {
			final Enrolment e = this.enrolmentService.findOne(enrolmentId);

			result = this.createEditModelAndView(e, null);

		} catch (final Exception oops) {
			oops.printStackTrace();
			result = new ModelAndView("welcome/index");
		}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Enrolment enrolment, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			System.out.println(binding.getAllErrors());
			result = this.createEditModelAndView(enrolment);
		} else
			try {
				enrolment = this.enrolmentService.save(enrolment);
				result = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				oops.printStackTrace();
				result = this.createEditModelAndView(enrolment, "enrolment.commit.error");
			}
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Enrolment enrolment) {
		ModelAndView result;
		try {
			Assert.isTrue(enrolment.getId() != 0);
			this.enrolmentService.delete(enrolment);
			result = new ModelAndView("redirect:../brotherhood/list.do");
		} catch (final Exception oops) {
			oops.printStackTrace();
			result = this.createEditModelAndView(enrolment, "enrolment.commit.error");
		}

		return result;
	}

	protected ModelAndView createEditModelAndView(final Enrolment enrolment) {
		return this.createEditModelAndView(enrolment, null);
	}

	protected ModelAndView createEditModelAndView(final Enrolment enrolment, final String messageCode) {
		ModelAndView result;
		final Collection<Member> members;
		final Collection<Member> myMembers = new ArrayList<Member>();
		final Collection<Position> positions;
		Brotherhood brotherhood;
		final Collection<Enrolment> enrolments;

		positions = this.positionService.findAll();
		members = this.memberService.findAll();
		brotherhood = enrolment.getBrotherhood();
		enrolments = this.enrolmentService.findByBrotherhoodId(brotherhood.getId());

		for (final Enrolment e : enrolments)
			myMembers.add(e.getMember());

		members.removeAll(myMembers);

		result = new ModelAndView("enrolment/edit");
		result.addObject("enrolment", enrolment);
		result.addObject("members", members);
		result.addObject("positions", positions);
		result.addObject("message", messageCode);

		return result;
	}

}
