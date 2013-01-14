package workshop.spring.aop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defined an AOP Aspect to log entry, exit and elapsed time of a function.
 * 
 * To achieve entry/exit logging, annotate the class/function with {@link EntryExitLogging}.
 * @author Anders Malmborg
 *
 */
@Aspect
public final class EntryExitLoggingAspect
{
    /**
     * Log enter/exit message including duration and eventually exception.
     * Package private for UnitTests.
     * @param pjp
     * @throws Throwable
     */
    @Around("@within(workshop.spring.aop.EntryExitLogging)")
    Object logEntryExit(final ProceedingJoinPoint pjp) throws Throwable
    {
        long startTime = System.currentTimeMillis();
        final StringBuilder bld = new StringBuilder(pjp.getTarget().getClass().getName());
        bld.append("#").append(pjp.getSignature().getName());
        final Logger logger = LoggerFactory.getLogger(bld.toString());
        logger.info("Enter:{}", bld.toString());
        if (logger.isDebugEnabled())
        {
            logger.debug("\tParameters:{}", Arrays.toString(pjp.getArgs()));
        }
        try
        {
            return pjp.proceed();
        }
        catch(Throwable e) //NOPMD : this is an aspect, we want to protocol all errors
        {
            bld.append(" with Exception ").append(e.getClass().getSimpleName()).append(":").append(e.getMessage());
            throw e;
        }
        finally
        {
            logger.info("Exit:{} - Duration:{}", bld.toString(), formatDuration(System.currentTimeMillis()-startTime));
        }
    }

    /**
     * Format the duration in ms to human readable.
     * @param elapsed elapsed time in ms
     * @return string
     */
    String formatDuration(final long elapsed)
    {
        final StringBuilder bld = new StringBuilder(Long.valueOf(elapsed).toString());
        bld.append(" ms");
        final String minSecsMs = "m:s,S";
        if (elapsed >= DateUtils.MILLIS_PER_HOUR)
        {
            String hourMinSecMs = "H:m:s,S";
            final Long hours = elapsed/DateUtils.MILLIS_PER_HOUR;
            final long reminder = elapsed - hours*DateUtils.MILLIS_PER_HOUR;
            final DateFormat fmt = new SimpleDateFormat(minSecsMs);
            bld.append(" (").append(hours.toString()).append(":");
            bld.append(fmt.format(new Date(reminder))).append(" ").append(hourMinSecMs).append(")");
        }
        else if (elapsed >= DateUtils.MILLIS_PER_MINUTE)
        {
            final DateFormat fmt = new SimpleDateFormat(minSecsMs);
            bld.append(" (").append(fmt.format(new Date(elapsed))).append(" ").append(minSecsMs).append(")");
        }
        else if (elapsed >= DateUtils.MILLIS_PER_SECOND)
        {
            String secsMs = "s,S";
            final DateFormat fmt = new SimpleDateFormat(secsMs);
            bld.append(" (").append(fmt.format(new Date(elapsed))).append(" ").append(secsMs).append(")");
        }
        return bld.toString();
    }
}
