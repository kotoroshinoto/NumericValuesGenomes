# Current Design Plan

## How to interpret AA sequences
- randomly pick 4-grams to assign scores to.
One value set for colors/pigments
- another value set for ints
- 4Grams with no mapping are white/zero
- If there is a run of multiple Adds/Subtracts from same value (either just the int, or R G or B)
  - apply percent bonus based on size of run when run ends)
## Bonuses for runs 
* 2-3 : 10% extra
* 4-9 : 25% extra
* 10-15 : 50% extra
* 16+ : 100% extra

## How to get value from nucleotide sequence: 
- transcribe DNA to RNA 
- translate RNA to AA:
- walk through AA sequence looking at 4-grams
- track any runs of continuous adding or subtracting. 
  - Zeroes or a switch between + or - will reset a run.

## More Thoughts on genome behaviors
Haploid genomes should have same interface as Diploid Genomes overall, with meiosis function for diploids, and nuclear fusion for haploids.
Reproductive functions: clonal_repr(int numoffspr), sex_repr(Diploid other, int numoffspr), both will apply mutations to genome in the process of reproducing, while one will additionally use meiosis and fusion to produce the final offspring.

Should thus be able to simulate haploid genomes that can reproduce by cloning themselves.

## Plans for Motifs will be scrapped for now
This sort of evolvable feature is too complicated to simulate easily, need to think more on how to do so