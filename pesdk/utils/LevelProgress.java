// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.util.Collection;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.Iterator;
import java.math.BigDecimal;
import java.util.TreeSet;
import java.math.MathContext;

public class LevelProgress
{
    private static final MathContext mathContext;
    private TreeSet<Level> progressLevels;
    
    public LevelProgress() {
        this.progressLevels = new TreeSet<Level>();
    }
    
    public synchronized BigDecimal getProgress() {
        BigDecimal stepCount = BigDecimal.ONE;
        BigDecimal steps = BigDecimal.ZERO;
        for (final Level level : this.progressLevels) {
            steps = steps.multiply(level.stepCount).add(level.step);
            stepCount = stepCount.multiply(level.stepCount);
        }
        return steps.divide(stepCount, LevelProgress.mathContext);
    }
    
    public synchronized float getProgressF() {
        return this.getProgress().floatValue();
    }
    
    public synchronized void reset() {
        this.progressLevels.clear();
    }
    
    public synchronized void setLevelProgress(final int level, final long stepCount, final long step) {
        final Level newLevel = new Level(step, stepCount, level);
        final TreeSet<Level> levelList = new TreeSet<Level>(this.progressLevels);
        final ArrayList<Level> removes = new ArrayList<Level>();
        for (final Level existingLevel : levelList) {
            if (existingLevel.level > level) {
                removes.add(existingLevel);
            }
            else {
                if (existingLevel.level != level) {
                    continue;
                }
                if (!existingLevel.isHigher(newLevel)) {
                    return;
                }
                removes.add(existingLevel);
            }
        }
        levelList.removeAll(removes);
        levelList.add(newLevel);
        this.progressLevels = levelList;
    }
    
    static {
        mathContext = MathContext.DECIMAL32;
    }
    
    private class Level implements Comparable<Level>
    {
        int level;
        BigDecimal step;
        BigDecimal stepCount;
        
        public Level(final long step, final long stepCount, final int level) {
            this.level = level;
            this.step = new BigDecimal(step);
            this.stepCount = new BigDecimal(stepCount);
        }
        
        public boolean isHigher(final Level level) {
            final BigDecimal progress1 = this.step.divide(this.stepCount, LevelProgress.mathContext);
            final BigDecimal progress2 = level.step.divide(level.stepCount, LevelProgress.mathContext);
            final BigDecimal max = progress1.max(progress2);
            return max.equals(progress2) && !max.equals(progress1);
        }
        
        @Override
        public int compareTo(final Level o) {
            return this.level - o.level;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            final Level level1 = (Level)o;
            return this.level == level1.level;
        }
        
        @Override
        public int hashCode() {
            return this.level;
        }
    }
}
