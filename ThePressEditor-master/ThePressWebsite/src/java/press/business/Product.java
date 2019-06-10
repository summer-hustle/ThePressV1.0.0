package press.business;

import java.text.NumberFormat;
import java.io.Serializable;

public class Product implements Serializable {

    private Long productId;    
    private String code;
    private String garmentType;
    private String garmentSize;
    private String garmentColor;
    private String foregroundTwill;
    private String foregroundStitch;
    private String backgroundTwill;
    private String backgroundStitch;
    private String stitchingFontFront;
    private String stitchingColorFront;
    private String stitchingFontBack;
    private String stitchingColorBack;
    private String stitchingFontLeft;
    private String stitchingColorLeft;
    private String stitchingFontRight;
    private String stitchingColorRight;
    private String stitchingFontHood;
    private String stitchingColorHood;
    private double price;
    
    public Product() {}

    public Long getId() {
        return productId;
    }

    public void setId(Long productId) {
        this.productId = productId;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getGarmentType() {
        return garmentType;
    }

    public void setGarmentType(String garmentType) {
        this.garmentType = garmentType;
    }

    public String getGarmentSize() {
        return garmentSize;
    }

    public void setGarmentSize(String garmentSize) {
        this.garmentSize = garmentSize;
    }

    public String getGarmentColor() {
        return garmentColor;
    }

    public void setGarmentColor(String garmentColor) {
        this.garmentColor = garmentColor;
    }

    public String getForegroundTwill() {
        return foregroundTwill;
    }

    public void setForegroundTwill(String foregroundTwill) {
        this.foregroundTwill = foregroundTwill;
    }

    public String getForegroundStitch() {
        return foregroundStitch;
    }

    public void setForegroundStitch(String foregroundStitch) {
        this.foregroundStitch = foregroundStitch;
    }

    public String getStitchingColorFront() {
        return stitchingColorFront;
    }

    public void setStitchingColorFront(String stitchingColorFront) {
        this.stitchingColorFront = stitchingColorFront;
    }

    public String getStitchingFontBack() {
        return stitchingFontBack;
    }

    public void setStitchingFontBack(String stitchingFontBack) {
        this.stitchingFontBack = stitchingFontBack;
    }
    
    

    public String getBackgroundTwill() {
        return backgroundTwill;
    }

    public void setBackgroundTwill(String backgroundTwill) {
        this.backgroundTwill = backgroundTwill;
    }

    public String getBackgroundStitch() {
        return backgroundStitch;
    }

    public void setBackgroundStitch(String backgroundStitch) {
        this.backgroundStitch = backgroundStitch;
    }

    public String getStitchingFontFront() {
        return stitchingFontFront;
    }

    public void setStitchingFontFront(String stitchingFontFront) {
        this.stitchingFontFront = stitchingFontFront;
    }

    public String getStitchingColorBack() {
        return stitchingColorBack;
    }

    public void setStitchingColorBack(String stitchingColorBack) {
        this.stitchingColorBack = stitchingColorBack;
    }

    public String getStitchingFontLeft() {
        return stitchingFontLeft;
    }

    public void setStitchingFontLeft(String stitchingFontLeft) {
        this.stitchingFontLeft = stitchingFontLeft;
    }

    public String getStitchingColorLeft() {
        return stitchingColorLeft;
    }

    public void setStitchingColorLeft(String stitchingColorLeft) {
        this.stitchingColorLeft = stitchingColorLeft;
    }

    public String getStitchingFontRight() {
        return stitchingFontRight;
    }

    public void setStitchingFontRight(String stitchingFontRight) {
        this.stitchingFontRight = stitchingFontRight;
    }

    public String getStitchingColorRight() {
        return stitchingColorRight;
    }

    public void setStitchingColorRight(String stitchingColorRight) {
        this.stitchingColorRight = stitchingColorRight;
    }

    public String getStitchingFontHood() {
        return stitchingFontHood;
    }

    public void setStitchingFontHood(String stitchingFontHood) {
        this.stitchingFontHood = stitchingFontHood;
    }

    public String getStitchingColorHood() {
        return stitchingColorHood;
    }

    public void setStitchingColorHood(String stitchingColorHood) {
        this.stitchingColorHood = stitchingColorHood;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }

  
}