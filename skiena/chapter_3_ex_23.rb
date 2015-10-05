class ListNode
  attr_accessor :val, :next
  def initialize(val)
    @val = val
    @next = nil
  end
 end

def reverse_list_iterative(head)
  return if head.nil?
  prev = nil
  curr = head
  while curr
    next_node = curr.next
    curr.next = prev
    prev = curr
    curr = next_node
  end
  head = prev
end

def reverse_list_recursive(head)
  return if head.nil?
  rest = head.next
  return if rest.nil?
  reverse(rest)
  head.next.next = head
  head.next = nil
  head = rest
end
