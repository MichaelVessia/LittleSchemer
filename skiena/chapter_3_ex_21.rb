# Definition for a binary tree node.
class TreeNode
  attr_accessor :val, :left, :right
  def initialize(val)
    @val = val
    @left = nil
    @right = nil
  end
end

def is_same_tree(p, q)
  p_nil = p.nil?
  q_nil = q.nil?

  return false if p_nil != q_nil
  return true if p_nil && q_nil

  p.val == q.val && is_same_tree(p.left, q.left) && is_same_tree(p.right, q.right)
end
