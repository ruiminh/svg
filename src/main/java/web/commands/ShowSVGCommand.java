package web.commands;

import business.exceptions.UserException;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSVGCommand extends CommandUnprotectedPage {

    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int a = 780; // todo: receive parameter of carport length.
        int b =600;   // todo: receive parameter of carport width.
        Double carportLength = Double.valueOf(a);
        Double carportWidth = Double.valueOf(b);
        int viewBoxWidth=a+75;
        int viewBoxHeight=b+90;
        String viewBox ="0 0 "+viewBoxWidth+" "+viewBoxHeight;
        String viewBoxInner="0 0 "+a+" "+b;

        SVG svg = new SVG(0,0,viewBox,100,100);

        SVG svgInner = new SVG(75,10,viewBoxInner,100,100);

        svgInner.addRect(0.0,0.0,carportWidth,carportLength);
        svgInner.addRect(0.0,0.0,carportWidth,4.5);
        svgInner.addRect(carportLength-4.5,0.0,carportWidth,4.5);
        svgInner.addRect(4.5,30.0,4.5,carportLength-(4.5*2));
        svgInner.addRect(4.5,b-30.0-4.5,4.5,carportLength-(4.5*2));
        svgInner.addDashLine(50,30,600,570);
        svgInner.addDashLine(50,570,600,30);
        svgInner.addRect((carportLength-40)/3,27.4,9.7,9.7);
        svgInner.addRect(2*(carportLength-40)/3,27.4,9.7,9.7);
        svgInner.addRect((carportLength-40),27.4,9.7,9.7);
        svgInner.addRect((carportLength-40)/3,carportWidth-34.5-2.7,9.7,9.7);
        svgInner.addRect(2*(carportLength-40)/3,carportWidth-34.5-2.7,9.7,9.7);
        svgInner.addRect((carportLength-40),carportWidth-34.5-2.7,9.7,9.7);


        svg.addSVG(svgInner);
        svg.addArrowMarkers();
        svg.addArrowLine(50,10,50,b+10);
        svg.addArrowLine(75,b+35,a+75,b+35);
        svg.addText(30,b/2,-90,b);
        svg.addText(75+a/2,b+65,0,a);

        request.setAttribute("svgdrawing",svg.toString());
        return pageToShow;
    }

}
