/**
 * Class Gift implementation.
 * 
 * Copyright 2011 Jan Minar <rdancer@rdancer.org>  All rights reserved.
 *
 * @author Jan Minar <rdancer@rdancer.org> 
 */
public class Gift
        implements Comparable
{
    private Integer price;
    private Double salesRanking;
    private String author;
    private String genre;
    private String format;
    /* TODO perhaps other attributes */
    
        
    /* Getters and setters */
    
    void setPrice(Integer price) {
        this.price = price;
    }
    
    Integer getPrice()
    {
        return this.price;
    }
    
    
    void setSalesRanking(Double salesRanking)
    {
        this.salesRanking = salesRanking;
    }
    
    Double getSalesRanking()
    {
        return this.salesRanking;
    }
    
    
    void setAuthor(String author)
    {
        this.author = author;
    }
    
    String getAuthor()
    {
        return this.author;
    }
    
    
    void setGenre(String genre)
    {
        this.genre = genre;
    }
    
    String getGenre()
    {
        return this.genre;
    }

    
    void setFormat(String format)
    {
        this.format = format;
    }
    
    String getFormat()
    {
        return this.format;
    }
    
    
    
    /*
     * Comparable
     */
    
    public int compareTo(Object other)
    {
        final int GREATER = 1;
        final int EQUAL = 0;
        final int LESSER = -1;
        int priceCompared;
        
        if (other.getClass() != this.getClass())
            return GREATER;
        
        Gift otherGift = (Gift)other;
        
        if((priceCompared = this.getPrice().compareTo(otherGift.getPrice())) != EQUAL)
        {
            return priceCompared;
        }
        else
        {
            assert(priceCompared == EQUAL);
            return this.getSalesRanking().compareTo(otherGift.getSalesRanking());
        }
    }
    
    public Gift clone()
    {
        Gift gift = new Gift();
        
        gift.setPrice(getPrice());
        gift.setSalesRanking(getSalesRanking());
        gift.setAuthor(getAuthor());
        gift.setGenre(getGenre());
        gift.setFormat(getFormat());
        
        return gift;
    }
}