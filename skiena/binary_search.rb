def binary_search(arr, item, low, high)
  return -1 if low > high
  middle = (low + high) / 2
  return middle if arr[middle] == item
  if arr[middle] > item
    binary_search(arr, item, low, middle - 1)
  else
    binary_search(arr, item, middle + 1, high)
  end
end

a = (1..10).to_a
puts binary_search(a, 4, 0, a.length)
