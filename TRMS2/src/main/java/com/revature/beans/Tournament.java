package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Tournament")
public class Tournament
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Tournament")
    @SequenceGenerator(name = "Tournament", sequenceName = "tournyid_seq", allocationSize = 1)
    private int tournament_id;
    private String tourny_type;
    private String style;
    private int owner_id;
    private int judge_id;
    private int min_num;
    private int max_num;
    
    public Tournament()
    {
        super();
    }
    
    public Tournament(
            int tournament_id,
            String tourny_type,
            String style,
            int owner_id,
            int judge_id,
            int min_num,
            int max_num)
    {
        super();
        this.tournament_id = tournament_id;
        this.tourny_type = tourny_type;
        this.style = style;
        this.owner_id = owner_id;
        this.judge_id = judge_id;
        this.min_num = min_num;
        this.max_num = max_num;
    }
    
    public int getTournament_id()
    {
        return tournament_id;
    }
    
    public void setTournament_id(int tournament_id)
    {
        this.tournament_id = tournament_id;
    }
    
    public String getTourny_type()
    {
        return tourny_type;
    }
    
    public void setTourny_type(String tourny_type)
    {
        this.tourny_type = tourny_type;
    }
    
    public String getStyle()
    {
        return style;
    }
    
    public void setStyle(String style)
    {
        this.style = style;
    }
    
    public int getOwner_id()
    {
        return owner_id;
    }
    
    public void setOwner_id(int owner_id)
    {
        this.owner_id = owner_id;
    }
    
    public int getJudge_id()
    {
        return judge_id;
    }
    
    public void setJudge_id(int judge_id)
    {
        this.judge_id = judge_id;
    }
    
    public int getMin_num()
    {
        return min_num;
    }
    
    public void setMin_num(int min_num)
    {
        this.min_num = min_num;
    }
    
    public int getMax_num()
    {
        return max_num;
    }
    
    public void setMax_num(int max_num)
    {
        this.max_num = max_num;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + judge_id;
        result = prime * result + max_num;
        result = prime * result + min_num;
        result = prime * result + owner_id;
        result = prime * result + ((style == null) ? 0 : style.hashCode());
        result = prime * result + tournament_id;
        result = prime * result + ((tourny_type == null) ? 0 : tourny_type.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Tournament other = (Tournament) obj;
        if (judge_id != other.judge_id) return false;
        if (max_num != other.max_num) return false;
        if (min_num != other.min_num) return false;
        if (owner_id != other.owner_id) return false;
        if (style == null)
        {
            if (other.style != null) return false;
        }
        else if (!style.equals(other.style)) return false;
        if (tournament_id != other.tournament_id) return false;
        if (tourny_type == null)
        {
            if (other.tourny_type != null) return false;
        }
        else if (!tourny_type.equals(other.tourny_type)) return false;
        return true;
    }
    
    @Override
    public String toString()
    {
        return "Tournament [tournament_id=" + tournament_id + ", tourny_type=" + tourny_type + ", style=" + style
                + ", owner_id=" + owner_id + ", judge_id=" + judge_id + ", min_num=" + min_num + ", max_num=" + max_num
                + "]";
    }
}
