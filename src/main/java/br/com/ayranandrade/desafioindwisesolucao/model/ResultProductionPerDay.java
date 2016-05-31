package br.com.ayranandrade.desafioindwisesolucao.model;

import java.time.LocalDate;

/**
 *
 * @author Ayran
 */
public final class ResultProductionPerDay implements Comparable<ResultProductionPerDay>
{
    private final int count;
    private final LocalDate date;

    public ResultProductionPerDay(int count, LocalDate date) {
        this.count = count;
        this.date = date;
    }

    public final int getCount() {
        return count;
    }

    public final LocalDate getDate() {
        return date;
    }

    @Override
    public int compareTo(ResultProductionPerDay o)
    {
      if(date.isBefore(o.getDate()))
      {
      return 1;
      }
      else if(date.isEqual(o.date))
      {
      return 0;
      }
    return -1;
    }
}