package org.scalacheck.support.cats

import cats.Monad
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
}

object Instances extends Instances
