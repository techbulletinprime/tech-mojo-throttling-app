package com.techmojo.throttler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppRequest {
   private int count;
   private  long time;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
