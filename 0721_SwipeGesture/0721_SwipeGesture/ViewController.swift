//
//  ViewController.swift
//  0721_SwipeGesture
//
//  Created by TJ on 2021/07/21.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var imgViewUp: UIImageView!
    @IBOutlet weak var imgViewLeft: UIImageView!
    @IBOutlet weak var imgViewRight: UIImageView!
    @IBOutlet weak var imgViewDown: UIImageView!
    
    var imgLeft = [UIImage]()
    var imgRigt = [UIImage]()
    var imgUp = [UIImage]()
    var imgDown = [UIImage]()
    var numOfTouches = 2 // 두 손가락이 Max
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        
        // Image 설정하기
        makeImages()
        
        // 초기 Image
        imgViewUp.image = imgUp[0]
        imgViewLeft.image = imgLeft[0]
        imgViewRight.image = imgRigt[0]
        imgViewDown.image = imgDown[0]
        
        // 한손가락 Gesture 구성
        makeSingleTouch()
        
        // 두손가락 Gesture 구성
        makeDoubleTouch()
    }
    
    func makeImages(){// 이미지 추가
        imgUp.append(UIImage(named: "arrow-up-black.png")!)
        imgDown.append(UIImage(named: "arrow-down-black.png")!)
        imgLeft.append(UIImage(named: "arrow-left-black.png")!)
        imgRigt.append(UIImage(named: "arrow-right-black.png")!)
        
        imgUp.append(UIImage(named: "arrow-up-red.png")!)
        imgDown.append(UIImage(named: "arrow-down-red.png")!)
        imgLeft.append(UIImage(named: "arrow-left-red.png")!)
        imgRigt.append(UIImage(named: "arrow-right-red.png")!)
        
        imgUp.append(UIImage(named: "arrow-up-green.png")!)
        imgDown.append(UIImage(named: "arrow-down-green.png")!)
        imgLeft.append(UIImage(named: "arrow-left-green.png")!)
        imgRigt.append(UIImage(named: "arrow-right-green.png")!)
    }
    
    // 1 손가락 터치
    func makeSingleTouch() {
        // UP
        let swipeUp = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGesture(_:))) // 인식
        swipeUp.direction = UISwipeGestureRecognizer.Direction.up
        self.view.addGestureRecognizer(swipeUp)
        
        // Down
        let swipeDown = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGesture(_:))) // 인식
        swipeDown.direction = UISwipeGestureRecognizer.Direction.down
        self.view.addGestureRecognizer(swipeDown)
        
        // Left
        let swipeLeft = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGesture(_:))) // 인식
        swipeLeft.direction = UISwipeGestureRecognizer.Direction.left
        self.view.addGestureRecognizer(swipeLeft)
        
        // Right
        let swipeRight = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGesture(_:))) // 인식
        swipeRight.direction = UISwipeGestureRecognizer.Direction.right
        self.view.addGestureRecognizer(swipeRight)
    }
    
    // 2 손가락 터치 ( alt(keyboard option) + shift -> 2손가락)
    func makeDoubleTouch() {
        // UP
        let swipeUp = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGestureMulti(_:))) // 인식
        swipeUp.direction = UISwipeGestureRecognizer.Direction.up
        swipeUp.numberOfTouchesRequired = numOfTouches // 2 손가락
        self.view.addGestureRecognizer(swipeUp)
        
        // Down
        let swipeDown = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGestureMulti(_:))) // 인식
        swipeDown.direction = UISwipeGestureRecognizer.Direction.down
        swipeDown.numberOfTouchesRequired = numOfTouches // 2 손가락
        self.view.addGestureRecognizer(swipeDown)
        
        // Left
        let swipeLeft = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGestureMulti(_:))) // 인식
        swipeLeft.direction = UISwipeGestureRecognizer.Direction.left
        swipeLeft.numberOfTouchesRequired = numOfTouches // 2 손가락
        self.view.addGestureRecognizer(swipeLeft)
        
        // Right
        let swipeRight = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGestureMulti(_:))) // 인식
        swipeRight.direction = UISwipeGestureRecognizer.Direction.right
        swipeRight.numberOfTouchesRequired = numOfTouches // 2 손가락
        self.view.addGestureRecognizer(swipeRight)
    }
    
    
    // object-c 함수 설정
    @objc func respondsToSwipeGesture(_ gesture: UIGestureRecognizer){
        if let swipeGesture = gesture as? UISwipeGestureRecognizer{ // 변환
            // 초기값
            imgViewUp.image = imgUp[0]
            imgViewDown.image = imgDown[0]
            imgViewLeft.image = imgLeft[0]
            imgViewRight.image = imgRigt[0]
            
            // 제스처가 들어오면
            switch swipeGesture.direction{
            case UISwipeGestureRecognizer.Direction.up:
                imgViewUp.image = imgUp[1]
            case UISwipeGestureRecognizer.Direction.down:
                imgViewDown.image = imgDown[1]
            case UISwipeGestureRecognizer.Direction.left:
                imgViewLeft.image = imgLeft[1]
            case UISwipeGestureRecognizer.Direction.right:
                imgViewRight.image = imgRigt[1]
            default:
                break
            }
        }
    }
    
    // object-c 함수 설정
    @objc func respondsToSwipeGestureMulti(_ gesture: UIGestureRecognizer){
        if let swipeGesture = gesture as? UISwipeGestureRecognizer{ // 변환
            // 초기값
            imgViewUp.image = imgUp[0]
            imgViewDown.image = imgDown[0]
            imgViewLeft.image = imgLeft[0]
            imgViewRight.image = imgRigt[0]
            
            // 제스처가 들어오면
            switch swipeGesture.direction{
            case UISwipeGestureRecognizer.Direction.up:
                imgViewUp.image = imgUp[2]
            case UISwipeGestureRecognizer.Direction.down:
                imgViewDown.image = imgDown[2]
            case UISwipeGestureRecognizer.Direction.left:
                imgViewLeft.image = imgLeft[2]
            case UISwipeGestureRecognizer.Direction.right:
                imgViewRight.image = imgRigt[2]
            default:
                break
            }
        }
    }


} // ViewController

