import Image, timeit, re

def rgb_to_hex(rgb):
  ''' converts RGB values to hex '''
  r = rgb[0]
  g = rgb[1]
  b = rgb[2]
  return '#%02X%02X%02X' % (r,g,b)

# open image to extract pixel rgb values from
im = Image.open("provinces.bmp")
pix = im.load()
width = im.size[0]
height = im.size[1]

# initialize dictionary to hold rgb and hex values, and the number of occurances
bucket = {}

# iterate through pixels in the image, extracting and storing rgb data
# the last value (5) in range(0, width, 5) and range(0, height, 5)
# is the step in the loop, skipping pixels, leave to 1 to sample all pixels
# note that for large images (1920, 1200) iterating through all the pixels
# could take a really long time, unless you want to modify the script
# and use numpy arrays
for col in range(0, width, 5):
    for row in range(0, height, 5):
        pixel_rgb = pix[col, row]
        if pixel_rgb in bucket.keys():
            bucket[pixel_rgb] += 1
        else:
            bucket[pixel_rgb] = 1

# the top value represents the top x occurances
top = 100
cols = []

# store the top pixel rgb values in a list
for w in sorted(bucket, key=bucket.get, reverse=True):
    hexcol = rgb_to_hex(w)
    cols.append([w])
    if top == 0: break
    top -= 1

# save the data to a txt file
# make sure an empty file with the proper name
# exists in the same folder as this script
with open('definition.csv', 'w') as f:
    for index, col in enumerate(cols):
      line = re.sub('\[|\(|\)|\]','',str(col))
      line = re.sub(', ',';',line)
      f.write(str(index+1) + ';' + line + ';A' + str(index+1) + ';x\n')
print('done')
