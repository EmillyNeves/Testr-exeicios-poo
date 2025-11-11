
#include <stdio.h>
#include <stdlib.h>
#include "binary_tree.h"


typedef struct BtNode
{
    int value;
    struct BtNode *left;
    struct BtNode *right;
} BtNode;

struct BinaryTree
{
    BtNode *root;
};


BtNode *node_construct(int value, BtNode *left, BtNode *right)
{
    BtNode *node = (BtNode*) calloc(1, sizeof(BtNode));

    node->value = value;
    node->left = left;
    node->right = right;

    return node;
}


void node_destroy(BtNode *node)
{
    free(node);
}


BinaryTree *binary_tree_construct()
{
    BinaryTree *bt = (BinaryTree *) calloc(1, sizeof(BinaryTree));
    bt->root = NULL;
    return bt;
}


void binary_tree_add(BinaryTree *bt, int value)
{
    BtNode *new_node = node_construct(value, NULL, NULL);

    if (bt->root == NULL)
    {
        bt->root = new_node;
    }
    else
    {
        BtNode *node = bt->root;

        while (node != NULL)
        {
            if (value == node->value)
            {
                node_destroy(new_node);
                return;
            }
            else if (value < node->value)
            {
                if (node->left == NULL)
                {
                    node->left = new_node;
                    return;
                }
                else
                    node = node->left;
            }
            else
            {
                if (node->right == NULL)
                {
                    node->right = new_node;
                    return;
                }
                else
                    node = node->right;
            }
        }
    }
}


int binary_tree_exists(BinaryTree *bt, int val)
{
    BtNode *n = bt->root;

    while (n != NULL)
    {
        if (val == n->value) return 1;
        else if (val < n->value) n = n->left;
        else n = n->right;
    }

    return 0;
}


int binary_tree_min(BinaryTree *bt)
{
    if (bt->root == NULL)
        exit(printf("Error: empty tree\n"));

    BtNode *n = bt->root;

    while (n->left != NULL)
        n = n->left;

    return n->value;
}


int binary_tree_max(BinaryTree *bt)
{
    if (bt->root == NULL)
        exit(printf("Error: empty tree\n"));

    BtNode *node = bt->root;

    while (node->right != NULL)
        node = node->right;

    return node->value;
}


void _destroy_node_recursive(BtNode *node)
{
    if (node == NULL)
        return;

    _destroy_node_recursive(node->left);
    _destroy_node_recursive(node->right);
    node_destroy(node);
}


void binary_tree_destroy(BinaryTree *bt)
{
    _destroy_node_recursive(bt->root);
    free(bt);
}


