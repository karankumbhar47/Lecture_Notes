#include <stdarg.h>
#include <stdlib.h>
#include <string.h>

#include "semantics.h"

TreeNode* makeNode(NodeType t, int numChild, ...){
  TreeNode* newNode;
  va_list params;

  newNode = (TreeNode *) malloc(sizeof(TreeNode));
  newNode->prodRule = t;
  newNode->token = 0;
  newNode->id = NULL;
  newNode->numChild = numChild;

  newNode->children = malloc(numChild * sizeof(TreeNode**));
  va_start(params, numChild);
  for (int i = 0; i < numChild; i++) {
    newNode->children[i] = va_arg(params, TreeNode*);
  }
  va_end(params);

  return newNode;
}
 
TreeNode* generateTerminal(int token, char * const id){
  TreeNode* node;
  node = (TreeNode *) malloc(sizeof(TreeNode));
  node->prodRule = 0;
  node->token = token;

  if (id != NULL) {
    node->id = malloc(sizeof(char) * (strlen(id) + 1));
    strcpy(node->id, id);
  } else {
    node->id = NULL;
  }

  node->numChild = 0;
  node->children = NULL;

  return node;
}
