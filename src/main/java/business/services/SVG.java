package business.services;

public class SVG {
    StringBuilder svg = new StringBuilder();
    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;
    private final String headerTemplate = "<svg height=\"%s%%\" "+
            "width=\"%s%%\" "+
            "viewBox=\"%s\" "+
            " x= \"%s\" "+
            " y= \"%s\" "+
            " preserveAspectRatio=\"xMinYMin\">";
    private final String rectTemplate = " <rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: none\"/>";
    private final String arrowMarkers = "<defs>\n" +
            "        <marker\n" +
            "                id=\"beginArrow\"\n" +
            "                markerWidth=\"12\"\n" +
            "                markerHeight=\"12\"\n" +
            "                refX=\"0\"\n" +
            "                refY=\"6\"\n" +
            "                orient=\"auto\">\n" +
            "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "        <marker\n" +
            "                id=\"endArrow\"\n" +
            "                markerWidth=\"12\"\n" +
            "                markerHeight=\"12\"\n" +
            "                refX=\"12\"\n" +
            "                refY=\"6\"\n" +
            "                orient=\"auto\">\n" +
            "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "    </defs>";
    private final String arrowTemplate ="<line x1=\"%d\"  y1=\"%d\" x2=\"%d\"   y2=\"%d\" style=\"stroke: #006600;" +
            " marker-start: url(#beginArrow); marker-end: url(#endArrow); \"/>";
    private final String textTemplate = "<text style=\"text-anchor: middle\" transform=\"translate(%s,%s) rotate(%s)\">%s cm</text>";
    private final String dashLineTemplate = "<line stroke-dasharray=\"10,5\" x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\"" +
            "                  style=\"stroke:#000000;stroke-width:2\" />";

    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate,height,width,viewBox,x,y));
    }

    public void addRect(Double x, Double y, Double height, Double width){
        svg.append(String.format(rectTemplate,x,y,height,width));

    };
    public void addLine(int x1, int y1, int x2, int y2){

    }
    public void addSVG(SVG innerSVG){
        svg.append(innerSVG.toString());

    }
    public void addArrowMarkers(){
        svg.append(String.format(arrowMarkers));
    }
    public void addArrowLine(int x1, int y1, int x2, int y2){
        svg.append(String.format(arrowTemplate,x1,y1,x2,y2));

    }
    public void addText(int x,int y, int degree,int text){
        svg.append(String.format(textTemplate,x,y,degree,text));
    }
    public void addDashLine(int x1,int y1,int x2,int y2){
        svg.append(String.format(dashLineTemplate,x1,y1,x2,y2));
    }


    @Override
    public String toString() {
        return svg.toString()+ "</svg>";
    }

}
