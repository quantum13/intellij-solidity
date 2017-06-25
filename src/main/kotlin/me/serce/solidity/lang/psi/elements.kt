package me.serce.solidity.lang.psi

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import me.serce.solidity.lang.resolve.ref.SolReference

interface SolElement : PsiElement {
  override fun getReference(): PsiReference?
}

interface SolNamedElement : SolElement, PsiNamedElement, NavigatablePsiElement

interface SolFunctionDefElement : SolReferenceElement {
  val modifiers: List<PsiElement>
  val parameters: List<SolParameterDef>
}

interface SolEnumDefElement : SolNamedElement

interface SolContractOrLibElement : SolNamedElement {
  val supers: List<SolUserDefinedTypeName>
}

interface SolReferenceElement : SolNamedElement {
  val referenceNameElement: PsiElement
  val referenceName: String

  override fun getReference(): SolReference?
}


