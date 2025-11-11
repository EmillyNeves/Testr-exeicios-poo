
#ifndef _BINARY_TREE_H_
#define _BINARY_TREE_H_

typedef struct BinaryTree BinaryTree;

// construct the tree
BinaryTree *binary_tree_construct();

// destroy the tree
void binary_tree_destroy(BinaryTree *bt);

// insert an element
void binary_tree_add(BinaryTree *bt, int value);

// check if an item exists in the tree
int binary_tree_exists(BinaryTree *bt, int val);

// search for the minimum in the tree
int binary_tree_min(BinaryTree *bt);

// search for the maximum in the tree
int binary_tree_max(BinaryTree *bt);

#endif