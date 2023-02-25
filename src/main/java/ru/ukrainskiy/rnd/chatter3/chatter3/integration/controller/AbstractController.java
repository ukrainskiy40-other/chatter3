package ru.ukrainskiy.rnd.chatter3.chatter3.integration.controller;

import java.util.function.*;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.exception.Chatter3RuntimeException;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.exception.EntityNotFoundException;
import ru.ukrainskiy.rnd.chatter3.chatter3.model.wrapper.Result;


@Slf4j
public class AbstractController {

	@FunctionalInterface
	public interface TriFunction<T, U, V, R> {
		R apply(T t, U u, V v);
	}

	@FunctionalInterface
	public interface FourParameterFunction<T, U, V, W, R> {
		R apply(T t, U u, V v, W w);
	}

	@FunctionalInterface
	public interface SixParameterFunction<T, U, V, W, Y, Z, R> {
		R apply(T t, U u, V v, W w, Y y, Z z);
	}

	protected <T, U, R> Result<R> result(BiFunction<T, U, R> s, T obj, U obj2) {
		try {
			return new Result<>(s.apply(obj, obj2));
		} catch (Exception e) {
			return resultError(e);
		}
	}

	protected <T, U, V, R> Result<R> result(TriFunction<T, U, V, R> s, T obj, U obj2, V obj3) {
		try {
			return new Result<>(s.apply(obj, obj2, obj3));
		} catch (Exception e) {
			return resultError(e);
		}
	}

	protected <T, U, V, W, R> Result<R> result(FourParameterFunction<T, U, V, W, R> s, T obj, U obj2, V obj3, W obj4) {
		try {
			return new Result<>(s.apply(obj, obj2, obj3, obj4));
		} catch (Exception e) {
			return resultError(e);
		}
	}

	protected <T, U, V, W, Y, Z, R > Result<R> result(SixParameterFunction<T, U, V, W, Y, Z, R> s, T obj, U obj2, V obj3, W obj4, Y obj5, Z obj6) {
		try {
			return new Result<>(s.apply(obj, obj2, obj3, obj4, obj5, obj6));
		} catch (Exception e) {
			return resultError(e);
		}
	}

	protected <T, R> Result<R> result(Function<T, R> s, T obj) {

		try {
			return new Result<>(s.apply(obj));
		} catch (Exception e) {
			return resultError(e);
		}
	}

	protected <T> Result<T> result(Consumer<T> s, T obj) {

		try {
			s.accept(obj);
			return Result.success();
		} catch (Exception e) {
			return resultError(e);
		}
	}

	protected <T, E> Result<T> result(BiConsumer<T, E> s, T obj1, E obj2) {

		try {
			s.accept(obj1, obj2);
			return Result.success();
		} catch (Exception e) {
			return resultError(e);
		}
	}

	protected <T> Result<T> result(Supplier<T> s) {

		try {
			return new Result<>(s.get());
		} catch (Exception e) {
			return resultError(e);
		}
	}

	protected <T> Result<T> resultError(Exception e) {

		log.error("Exception: ", e);
		if (e instanceof EntityNotFoundException) {
			return Result.error(
					EntityNotFoundException.class.getSimpleName(),
					e.getMessage());
		} else if (e instanceof Chatter3RuntimeException) {
			Chatter3RuntimeException se = (Chatter3RuntimeException) e;
			return Result.error(se.getClass().getSimpleName(), se.getMessage());
		} else if (e instanceof ConstraintViolationException) {
			return Result.error(e.getClass().getSimpleName(), e.getMessage());
		}
		return Result.error(e.getClass().getSimpleName(), e.getMessage());
	}

	@ExceptionHandler(AccessDeniedException.class)
	private ResponseEntity<?> handlerControllerException() {
		return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
	}

}
