package org.scalacheck.support.cats

import cats.Monad
import cats.Semigroup
import cats.syntax.semigroup._
import org.scalacheck.Gen

trait Instances {
  implicit val genMonad: Monad[Gen] = new Monad[Gen] {

    def pure[A](a: A): Gen[A] = Gen.const(a)

    def flatMap[A, B](fa: Gen[A])(f: A => Gen[B]): Gen[B] = fa flatMap f

    def tailRecM[A, B](a: A)(f: (A) ⇒ Gen[Either[A, B]]): Gen[B] =
      f(a) flatMap {
        case Right(b) => pure(b)
        case Left(aa) => tailRecM(aa)(f)
      }
  }
  
   implicit def genSemigroup[T: Semigroup]: Semigroup[Gen[T]] = new Semigroup[Gen[T]] {
    def combine(g1: Gen[T], g2: Gen[T]): Gen[T] = for { t1 <- g1; t2 <- g2 } yield t1 |+| t2
  }
}

object Instances extends Instances
