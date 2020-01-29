#include <cstdlib>
#include <climits>

#include "SLList.hpp"

using namespace std;

SLList * const SLList::NIL = new SLList(0, NULL);

SLList::SLList(int i, SLList *n) {
  fst = i; rst = n;
}

int SLList::first() {
  return fst;
}

SLList *SLList::rest() {
  return rst;
}

void SLList::setFirst(int i) {
  fst = i;
}

void SLList::setRest(SLList *n) {
  rst = n;
}

int SLList::nth(unsigned int i) {
  if (i == 0)
    return first();
  else
    return rest()->nth(i-1);
}

SLList *SLList::nthRest(unsigned int i) {
  if (i == 0)
    return this;
  else
    return rest()->nthRest(i-1);
}

unsigned int SLList::length() {
  unsigned int l = 0;
  SLList *c = this;
  while(c != SLList::NIL) {
    l++;
    c = c->rest();
  }
  return l;
}

SLList *SLList::remove(int i) {
  if (this == SLList::NIL)
    return SLList::NIL;
  else if (first() == i)
    return rest()->remove(i);
  else
    return new SLList(first(), rest()->remove(i));
}

SLList *SLList::reverse(SLList *sofar) {
  if (this == SLList::NIL)
    return sofar;
  else
    return rest()->reverse(new SLList(first(), sofar));
}

SLList *SLList::sublist(int start, int end) {
  return NIL;
}

SLList *SLList::merge(SLList *b) {
  return NIL;
}

SLList *SLList::mergesort() {
  return NIL;
}
