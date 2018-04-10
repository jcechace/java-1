package cz.czechitas.angrybirds.engine;

import java.awt.*;
import java.lang.reflect.*;
import java.util.concurrent.*;
import javax.swing.*;
import cz.czechitas.angrybirds.api.*;
import net.sevecek.util.*;

public class Utils {

    public static <RESULT> RESULT invokeAndWait(Callable<RESULT> code) {
        if (Thread.currentThread().isInterrupted()) {
            throw new CancellationException();
        }
        Utils.Holder<RESULT> result = new Utils.Holder<>();
        if (!SwingUtilities.isEventDispatchThread()) {
            try {
                SwingUtilities.invokeAndWait(() -> {
                    try {
                        result.value = code.call();
                    } catch (Exception e) {
                        throw ExceptionUtils.rethrowAsUnchecked(e);
                    }
                });
            } catch (InterruptedException e) {
                throw new CancellationException();
            } catch (InvocationTargetException e) {
                throw ExceptionUtils.rethrowAsUnchecked(e);
            }
        } else {
            try {
                result.value = code.call();
            } catch (Exception e) {
                throw ExceptionUtils.rethrowAsUnchecked(e);
            }
        }
        return result.value;
    }

    public static void invokeAndWait(Runnable code) {
        if (Thread.currentThread().isInterrupted()) {
            throw new CancellationException();
        }
        if (!SwingUtilities.isEventDispatchThread()) {
            try {
                SwingUtilities.invokeAndWait(() -> {
                    code.run();
                });
            } catch (Exception e) {
                throw ExceptionUtils.rethrowAsUnchecked(e);
            }
        } else {
            code.run();
        }
    }

    public static void invokeLater(Runnable code) {
        if (Thread.currentThread().isInterrupted()) {
            throw new CancellationException();
        }
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(code);
        } else {
            code.run();
        }
    }

    public static boolean detectCollision(JComponent component1, JComponent component2) {
        int ax = component1.getX();
        int ay = component1.getY();
        int bx = component1.getX() + component1.getWidth();
        int by = component1.getY() + component1.getHeight();
        int cx = component2.getX();
        int cy = component2.getY();
        int dx = component2.getX() + component2.getWidth();
        int dy = component2.getY() + component2.getHeight();

        if (bx > cx && by > cy
                && ax < dx && ay < dy) {
            return true;
        } else {
            return false;
        }
    }

    private static class Holder<T> {

        public T value;

    }
}
